package edu.tcd.tapserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tcd.tapserve.bean.RatingReview;
import edu.tcd.tapserve.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/psotReview/{serviceProvider}")
	@CrossOrigin(origins = "http://localhost:8080")
	public RatingReview postReviewForServiceProvider(@RequestBody RatingReview review) {
		return reviewService.postReviewForServiceProvider(review);
	}

}
