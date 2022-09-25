package com.techelevator.service;

import com.techelevator.dao.BeerDao;
import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryService {
    private BeerDao beerDao;
    private BreweryDao  breweryDao;

    public BreweryService(BeerDao beerDao, BreweryDao breweryDao) {
        this.beerDao = beerDao;
        this.breweryDao = breweryDao;
    }

}
