package edu.tcd.tapserve.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.tcd.tapserve.bean.Role;
import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.repository.UserRepository;

public class UserInfoServiceTest {
	@InjectMocks
	private UserInfoService userInfoService;
	
	@Mock
	private UserRepository userRepository;
	

	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidUser(){
		Role role = new Role();
		role.setName("Administrator");
		
		User user = new User();
		user.setName("TestUser");
		user.setId("TestID1234");
		user.setRole(role);
		
		Mockito.when(userRepository.findByName("TestUser")).thenReturn(user);
		
		assertEquals("TestUser", userInfoService.getUserInfo("TestUser").getName());
		assertEquals("TestID1234", userInfoService.getUserInfo("TestUser").getId());
		assertEquals("Administrator", userInfoService.getUserInfo("TestUser").getRole().getName());
	}
}
