package edu.tcd.tapserve.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.Service;
import edu.tcd.tapserve.bean.ServiceToProviderMapper;

public interface ServiceToProviderMapperRepository extends CrudRepository<ServiceToProviderMapper, String> {

	public List<ServiceToProviderMapper> findByService(Service service);
}
