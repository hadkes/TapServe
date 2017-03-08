package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.User;

public interface UserRepository extends CrudRepository<User, String> {

	public User findByFbId(Long fbId);
	
	public User findByName(String name);
}
