package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    List<Brewery> findAll();

    Brewery findBreweryById(long id);

    Brewery findBreweryByName(String name);

    Brewery findBreweryByCity(String city);

    boolean createBrewery(String name, String street, String city, String state, String phoneNumber, String hoursOfOperation, String imageUrl, String history);
}
