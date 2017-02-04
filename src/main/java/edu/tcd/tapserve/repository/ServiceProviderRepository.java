package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.ServiceProvider;

public interface ServiceProviderRepository extends CrudRepository<ServiceProvider, String> {

	public ServiceProvider findByRoleId(String roleId);
}
