package com.techelevator.dao;

import com.techelevator.model.Profile;

public interface ProfileDao {

    String findType(String username);

    void createProfile(String username, String profileType);
}
