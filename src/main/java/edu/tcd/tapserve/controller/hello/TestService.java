package edu.tcd.tapserve.controller.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.bean.User;

@Service
public class TestService {
	
	@Autowired
	private ServiceProviderRepository testInterface;
	
	public ServiceProvider findByRoleId(String roleId){
		return testInterface.findByRoleId(roleId);
	}
	
}
