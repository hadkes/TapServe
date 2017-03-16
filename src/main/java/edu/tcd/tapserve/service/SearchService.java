package edu.tcd.tapserve.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.CustomServiceProvider;
import edu.tcd.tapserve.bean.RatingReview;
import edu.tcd.tapserve.bean.ServiceToProviderMapper;
import edu.tcd.tapserve.repository.RatingReviewRepository;
import edu.tcd.tapserve.repository.ServiceRepository;
import edu.tcd.tapserve.repository.ServiceToProviderMapperRepository;

@Service
public class SearchService {

	@Autowired
	private ServiceToProviderMapperRepository mapperRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private RatingReviewRepository ratingReviewRepository;

	@Autowired
	private FriendService friendService;

	public List<CustomServiceProvider> getSearchResult(String userId, String regionId, String serviceId) {
		List<CustomServiceProvider> customServiceProviders = new ArrayList<CustomServiceProvider>();
		edu.tcd.tapserve.bean.Service service = serviceRepository.findOne(serviceId);
		List<ServiceToProviderMapper> mapperObjects = mapperRepository.findByService(service);

		for (ServiceToProviderMapper mapper : mapperObjects) {
			if (!mapper.getServiceProvider().getRegionIdentifier().equals(regionId))
				continue;

			CustomServiceProvider customObj = new CustomServiceProvider();
			customObj.setServiceProvider(mapper.getServiceProvider());

			List<RatingReview> reviews = ratingReviewRepository.findByServiceProvider(mapper.getServiceProvider());
			customObj.setReviews(reviews);

			//customObj.setReviewsByFriends(friendService.getFriendsReviews(reviews, userId));

			customServiceProviders.add(customObj);
		}
		
		Collections.sort(customServiceProviders,
				Collections.reverseOrder(CustomServiceProvider.COMPARE_BY_FRIEND_REVIEWS));
		
		return customServiceProviders;
	}

}
