package edu.tcd.tapserve.repository;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Service;

public interface ServiceRepository extends CrudRepository<Service, String> {

}
