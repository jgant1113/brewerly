package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JdbcBeerDao implements BeerDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Beer> findAll(int breweryId) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT * FROM beers where brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()) {
            beers.add(mapRowToBeer(results));
        }
        return beers;
    }

    @Override
    public Beer findBeerByBeerId(int beerId) {
        String sql = "SELECT * FROM beers WHERE beer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
        if(results.next()){
            return mapRowToBeer(results);
        } else {
            throw new RuntimeException("BeerId "+beerId+" was not found.");
        }
    }

    @Override
    public boolean addBeerToBrewery(int beer_id, String name, String style, int brewery_id, String abv, String ibu, String color) {
        String sql = "INSERT INTO beers (beer_id, name, style, brewery_id, abv, ibu, color) VALUES (?, ? ,?, ?, ?, ?, ?) ; ";
        jdbcTemplate.update(sql, beer_id, name, style, brewery_id, abv, ibu, color);
        return true;
    }

    //Added by Jeremy
    @Override
    public void removeBeer(int beerId) {
        String sql = "DELETE FROM beers WHERE beer_id = ?;";
        jdbcTemplate.update(sql, beerId);
    }

    //Mapping
    public Beer mapRowToBeer(SqlRowSet rs){
        Beer beer = new Beer();
        beer.setBeerId(rs.getInt("beer_id"));
        beer.setName(rs.getString("name"));
        beer.setStyle(rs.getString("style"));
        beer.setBreweryId(rs.getInt("brewery_id"));
        beer.setAbv(rs.getString("abv"));
        beer.setIbu(rs.getString("ibu"));
        beer.setColor(rs.getString("color"));
        return beer;
    }

}