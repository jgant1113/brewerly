package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class BeerController {

    private BeerDao beerDao;

    public BeerController(BeerDao beerDao) {this.beerDao=beerDao;}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value ="/beer/new", method = RequestMethod.POST)
    public Beer addBeerToBrewery(@Valid @RequestBody Beer beer) {
        if (beerDao.addBeerToBrewery(beer.getBeerId(), beer.getName(),beer.getStyle(),beer.getBreweryId(), beer.getAbv(), beer.getIbu(),
                beer.getColor())){
            return beer;
        }
        return null;
    }

    //Added By Jeremy
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/beer/remove/{id}", method = RequestMethod.DELETE)
    public void removeBeer(@PathVariable(name = "id") int beerId) {
        beerDao.removeBeer(beerId);
    }

    //Get a beer by its ID
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/beer/get/{id}")
    public Beer findBeerByBeerId(@PathVariable(name = "id") int beerId) {
        return beerDao.findBeerByBeerId(beerId);
    }

    //Pulls list of beers by BreweryID
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/beer/getAll/{id}")
    public List<Beer> findAllBeersByBreweryId(@PathVariable(name = "id") int breweryId) {
        return beerDao.findAll(breweryId);
    }


}
