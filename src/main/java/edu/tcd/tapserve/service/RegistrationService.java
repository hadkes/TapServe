package edu.tcd.tapserve.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.Administrator;
import edu.tcd.tapserve.bean.Credentials;
import edu.tcd.tapserve.bean.Role;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.constants.Constants.RoleType;
import edu.tcd.tapserve.repository.AdministratorRepository;
import edu.tcd.tapserve.repository.CredentialsRepository;
import edu.tcd.tapserve.repository.RoleRepository;
import edu.tcd.tapserve.repository.ServiceProviderRepository;
import edu.tcd.tapserve.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private AdministratorRepository administratorRepository;

	public String addCredentials(Credentials credentials) {
		credentials.setId(UUID.randomUUID().toString());
		String actorId = UUID.randomUUID().toString();
		credentials.setActorId(actorId);
		credentialsRepository.save(credentials);
		return actorId;
	}

	public User addUser(User user) {
		Role role = roleRepository.findByName(RoleType.USER.name());
		user.setRole(role);
		userRepository.save(user);
		return user;
	}

	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		Role role = roleRepository.findByName(RoleType.SERVICE_PROVIDER.name());
		serviceProvider.setRole(role);
		serviceProviderRepository.save(serviceProvider);
		return serviceProvider;
	}

	public Administrator addAdministrator(Administrator administrator) {
		Role role = roleRepository.findByName(RoleType.ADMIN.name());
		administrator.setRole(role);
		administratorRepository.save(administrator);
		return administrator;
	}
}
