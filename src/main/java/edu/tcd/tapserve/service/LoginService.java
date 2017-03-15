package edu.tcd.tapserve.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.Administrator;
import edu.tcd.tapserve.bean.Credentials;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.repository.AdministratorRepository;
import edu.tcd.tapserve.repository.CredentialsRepository;
import edu.tcd.tapserve.repository.ServiceProviderRepository;
import edu.tcd.tapserve.repository.UserRepository;
import edu.tcd.tapserve.utils.PasswordEncryptionUtil;

@Service
public class LoginService {

	private final Logger logger = LoggerFactory.getLogger(RegistrationService.class);

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private AdministratorRepository administratorRepository;

	public Object loginActor(Credentials credentials) {
		if (credentials == null) {
			logger.warn("Input credentails object cannot be null.");
			return null;
		}

		if (credentials.getUsername() == null || credentials.getPassword() == null) {
			logger.warn("Username or passward of credentails cannot be null.");
			return null;
		}

		String username = credentials.getUsername();
		String password = credentials.getPassword();

		Credentials dbCredentials = credentialsRepository.findByUsername(username);
		if (dbCredentials == null) {
			logger.warn("Wrong credentials provided for actor with username " + username);
			return null;
		}

		if (!dbCredentials.getPassword().equals(PasswordEncryptionUtil.encrypt(password))) {
			logger.warn("Wrong credentials provided for actor with username " + username);
			return null;
		}

		String actorId = dbCredentials.getActorId();

		User user = userRepository.findOne(actorId);
		if (user != null) {
			logger.debug("Found user with username " + username);
			return user;
		}

		ServiceProvider serviceProvider = serviceProviderRepository.findOne(actorId);
		if (serviceProvider != null) {
			logger.debug("Found Service Provider with username " + username);
			return serviceProvider;
		}

		Administrator admin = administratorRepository.findOne(actorId);
		if (admin != null) {
			logger.debug("Found Administrator with username " + username);
			return admin;
		}

		logger.warn("Actor with username " + username + " not found");
		return null;
	}
}
