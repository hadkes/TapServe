package edu.tcd.tapserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.repository.UserRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUserInfo(String userName){
		return userRepository.findByName(userName);
	}
}
