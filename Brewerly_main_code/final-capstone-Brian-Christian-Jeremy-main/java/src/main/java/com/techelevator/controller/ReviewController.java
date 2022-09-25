package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class ReviewController {

    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao){
        this.reviewDao=reviewDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/review/new", method = RequestMethod.POST)
    public Review newReview(@Valid @RequestBody Review review) {
        if (reviewDao.addReviewToBeer(review.getReviewId(),review.getUsername(),review.getRating(),review.getBeerId(),
                review.getBreweryId(), review.getDetail())) {
            return review;
        }
        return null;
    }

    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/review/get/user/{username}")
    public Review getAllReviewsUser(@PathVariable(name = "username") String userNameReview) {
        return reviewDao.getAllReviewsFromUser(userNameReview);
    }

    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/review/get/beer/{beer_id}")
    public Review getAllReviewsBeer(@PathVariable(name = "beer_id") String allBeerReview) {
        return (Review) reviewDao.getAllReviewsFromBeer(allBeerReview);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/review/get/avg/{beer_id}")
    public int avgRatingTotal(@PathVariable (name = "beer_id") int ratingAvg){
        return reviewDao.getAvgRating(ratingAvg);
    }

}
