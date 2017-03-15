package edu.tcd.tapserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.Credentials;
import edu.tcd.tapserve.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@CrossOrigin(origins = "http://localhost:8080")
	public Object loginActor(@RequestBody Credentials credentials) {
		return loginService.loginActor(credentials);
	}
}
