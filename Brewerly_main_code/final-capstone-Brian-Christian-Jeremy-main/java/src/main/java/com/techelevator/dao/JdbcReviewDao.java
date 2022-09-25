package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcReviewDao implements ReviewDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    @Override
    public boolean addReviewToBeer(int reviewId, String username, int rating, int beer_id, int brewery_id, String detail){
        String sql = "INSERT INTO reviews (review_id, username, rating, beer_id, brewery_id, detail)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, reviewId, username, rating, beer_id, brewery_id, detail);
        return true;
    }

    @Override
   public List<Review> getAllReviewsFromBeer(String allBeerReview){
        List<Review> beerReview = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE beer_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            beerReview.add(mapRowToReview(results));
        }
        return beerReview;
    }

    public Review getAllReviewsFromUser(String userNameReview){
        List<Review> userReview = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE username = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            userReview.add(mapRowToReview(results));
        }
        return (Review) userReview;
    }

    @Override
    public int getAvgRating(int ratingAvg){
        String sql="SELECT AVG(rating)::NUMERIC(10,2)  FROM reviews WHERE beer_id = ?;";
        return ratingAvg;
    }

    public Review mapRowToReview(SqlRowSet rs){
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setUsername(rs.getString("username"));
        review.setRating(rs.getInt("name"));
        review.setBeerId(rs.getInt("beer_id"));
        review.setBreweryId(rs.getInt("brewery_id"));
        review.setDetail(rs.getString("detail"));
        return review;
    }
}

