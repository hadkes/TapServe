package edu.tcd.tapserve.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcd.tapserve.bean.RatingReview;
import edu.tcd.tapserve.repository.RatingReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private RatingReviewRepository ratingReviewRepository;

	public RatingReview postReviewForServiceProvider(RatingReview review) {
		review.setId(UUID.randomUUID().toString());
		ratingReviewRepository.save(review);
		return review;
	}

}
