package edu.tcd.tapserve.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.RatingReview;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.repository.RatingReviewRepository;
import edu.tcd.tapserve.repository.ServiceProviderRepository;

@Service
public class ReviewService {

	@Autowired
	private RatingReviewRepository ratingReviewRepository;

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	public RatingReview postReviewForServiceProvider(RatingReview review) {
		review.setId(UUID.randomUUID().toString());
		ratingReviewRepository.save(review);
		return review;
	}

	public List<RatingReview> getReviewsForServiceProvider(String serviceProviderId) {
		List<RatingReview> reviews = new ArrayList<RatingReview>();
		ServiceProvider serviceProvider = serviceProviderRepository.findOne(serviceProviderId);
		reviews = ratingReviewRepository.findByServiceProvider(serviceProvider);
		return reviews;

	}

}
