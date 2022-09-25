package com.techelevator.model;

public class Profile {

    private int profileId;
    private String username;
    private String profileType;

    public Profile(){};

    public Profile(String username, int profileId, String profileType){
        this.profileId = profileId;
        this.username = username;
        this.profileType = profileType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }
}