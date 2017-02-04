package edu.tcd.tapserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.Administrator;
import edu.tcd.tapserve.bean.Credentials;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String registerActor(@RequestBody Credentials credentials) {
		return registrationService.addCredentials(credentials);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/user/{id}")
	public User registerUser(@RequestBody User user, @PathVariable String id) {
		return registrationService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/service_provider/{id}")
	public ServiceProvider registerServiceprovider(@RequestBody ServiceProvider serviceProvider,
			@PathVariable String id) {
		return registrationService.addServiceProvider(serviceProvider);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/administrator/{id}")
	public Administrator registerAdministrator(@RequestBody Administrator administrator, @PathVariable String id) {
		return registrationService.addAdministrator(administrator);
	}

}
