package edu.tcd.tapserve.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.tcd.tapserve.bean.RatingReview;
import edu.tcd.tapserve.bean.ServiceProvider;

public interface RatingReviewRepository extends CrudRepository<RatingReview, String> {

	public List<RatingReview> findByServiceProvider(ServiceProvider serviceProvider);
}
