package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Brewery {

    private long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String phoneNumber;
    private String hoursOfOperation;
    private String imageUrl;
    private String history;
    private List <Beer> listOfBeers;

    public Brewery(long id, String name, String street, String city, String state, String phoneNumber, String hoursOfOperation, String imageUrl, String history, List<Beer> listOfBeers) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.hoursOfOperation = hoursOfOperation;
        this.imageUrl = imageUrl;
        this.history = history;
        this.listOfBeers = listOfBeers;
    }

    public Brewery() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<Beer> getListOfBeers() {
        return listOfBeers;
    }

    public void setListOfBeers(List<Beer> listOfBeers) {
        this.listOfBeers = listOfBeers;
    }
}
