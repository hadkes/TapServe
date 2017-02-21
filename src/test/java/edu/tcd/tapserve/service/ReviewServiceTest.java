package edu.tcd.tapserve.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.tcd.tapserve.bean.RatingReview;
import edu.tcd.tapserve.repository.RatingReviewRepository;

public class ReviewServiceTest {

	@InjectMocks
	ReviewService reviewService = new ReviewService();

	@Mock
	RatingReviewRepository mockedRatingReviewRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPostReview() {
		RatingReview review = new RatingReview();
		review.setRating(5);
		review.setReview("review");

		Mockito.when(mockedRatingReviewRepository.save(review)).thenReturn(review);

		assertEquals("review", reviewService.postReviewForServiceProvider(review).getReview());
		assertEquals(5, reviewService.postReviewForServiceProvider(review).getRating());
	}

}
