package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, String> {

	public Credentials findByUsername(String username);
}
