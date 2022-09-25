package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import com.techelevator.model.LoginDTO;
import com.techelevator.model.User;
import com.techelevator.security.jwt.JWTFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class BreweryController {

    //All methods below work in Postman! "Jeremy"

    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    //Note that since the JdbcBreweryDao create method isn't finished this is still ugly.
    //Postman Tested- Complete
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/brewery/new", method = RequestMethod.POST)
    public Brewery addBrewery(@Valid @RequestBody Brewery br) {
        if (breweryDao.createBrewery(br.getName(), br.getStreet(), br.getCity(), br.getState(), br.getPhoneNumber(), br.getHoursOfOperation(), br.getImageUrl(), br.getHistory())) {
            return br;
        }
        return null;
    }

    //Basic methods to get all breweries, or get one by name or location. No delete brewery option yet.
    //Postman Tested- Complete
    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/brewery/all")
    public List<Brewery> getAllBreweries() {
        return breweryDao.findAll();
    }

    //Postman Tested- Complete
    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/brewery/get/{id}")
    public Brewery findBreweryByID(@PathVariable(name = "id") long breweryId) {
        return breweryDao.findBreweryById(breweryId);
    }

    //Postman Tested- Complete
    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/brewery/find/{city}")
    public Brewery findBreweryByCity(@PathVariable(name = "city") String city) {
        return breweryDao.findBreweryByCity(city);
    }
    //End of basic methods
}
