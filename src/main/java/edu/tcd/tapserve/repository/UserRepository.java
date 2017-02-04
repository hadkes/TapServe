package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.User;

public interface UserRepository extends CrudRepository<User, String> {

}
