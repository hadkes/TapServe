package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, String> {

}
