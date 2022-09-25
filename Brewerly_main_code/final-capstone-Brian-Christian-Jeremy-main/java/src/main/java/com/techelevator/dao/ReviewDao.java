package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {




   boolean addReviewToBeer(int reviewId, String username, int rating, int beer_id, int brewery_id, String detail);

   List<Review> getAllReviewsFromBeer(String allBeerReview);

   Review getAllReviewsFromUser(String username);

   int getAvgRating(int ratingAvg);
}
