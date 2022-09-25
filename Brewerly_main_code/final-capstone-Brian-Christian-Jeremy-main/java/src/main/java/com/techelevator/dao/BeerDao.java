package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

import java.util.List;

public interface BeerDao {


    List<Beer> findAll(int breweryId);

    Beer findBeerByBeerId(int beerId);

    boolean addBeerToBrewery(int beer_id, String name, String style, int brewery_id, String abv, String ibu, String color);

    void removeBeer(int beerId);
}
