package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

	public Role findByName(String name);
}
