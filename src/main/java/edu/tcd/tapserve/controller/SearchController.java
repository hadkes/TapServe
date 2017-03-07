package edu.tcd.tapserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.CustomServiceProvider;
import edu.tcd.tapserve.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	@RequestMapping(method = RequestMethod.GET, value = "/findServiceProviders/{userId}/{regionId}/{serviceId}")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<CustomServiceProvider> getSearchResult(@PathVariable String userId, @PathVariable String regionId,
			@PathVariable String serviceId) {

		return searchService.getSearchResult(userId, regionId, serviceId);
	}
}
