package com.techelevator.model;

public class Review {
    private int reviewId;
    private String username;
    private int rating;
    private int beerId;
    private int breweryId;
    private String detail;

    public Review(int reviewId, String username, int rating, int beerId, int breweryId, String detail) {
        this.reviewId = reviewId;
        this.username = username;
        this.rating = rating;
        this.beerId = beerId;
        this.breweryId = breweryId;
        this.detail = detail;
    }

    public Review() {}

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}


//    review_id serial,
//    username character varying(50) NOT NULL,
//    rating integer default 1 NOT NULL check (rating between 1 and 5),
//        beer_id integer references beers(beer_id) NOT NULL,
//        brewery_id integer references breweries(brewery_id) NOT NULL,
//        detail character varying(2000),