package com.techelevator.controller;


import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.JdbcProfileDao;
import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class ProfileController {
    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    //Need to convert to path variable
    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/profile/{username}")
    public String getProfileType(@PathVariable String username){
        return profileDao.findType(username);
    }

    //Working
    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/profile/add")
    public void createProfile(@Valid @RequestBody Profile profile){

        profileDao.createProfile(profile.getUsername(), profile.getProfileType());
    }


}
