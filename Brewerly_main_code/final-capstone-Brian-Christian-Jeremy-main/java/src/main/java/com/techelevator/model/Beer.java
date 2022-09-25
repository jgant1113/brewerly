package com.techelevator.model;

import java.util.List;

public class Beer {
    private int beerId;
    private String name;
    private int breweryId;
    private String style;
    private String abv;
    private String ibu;
    private String color;
    private List<Beer> listOfBeers;

    public Beer(int beerId, String name, int breweryId, String style, String abv, String ibu, String color, List<Beer> listOfBeers) {
        this.beerId = beerId;
        this.name = name;
        this.breweryId = breweryId;
        this.style = style;
        this.abv = abv;
        this.ibu = ibu;
        this.color = color;
        this.listOfBeers = listOfBeers;
    }

    public Beer(int beerId, String name, int breweryId, String style, String abv, String ibu, String color) {
        this.beerId = beerId;
        this.name = name;
        this.breweryId = breweryId;
        this.style = style;
        this.abv = abv;
        this.ibu = ibu;
        this.color = color;

    }

    public Beer() {
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getStyle() {return style;}

    public void setStyle(String style) {this.style = style;}


    public String getAbv() {return abv;}

    public void setAbv(String abv) {this.abv = abv;}

    public String getIbu() {return ibu;}

    public void setIbu(String ibu) {this.ibu = ibu;}

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}

    public List<Beer> getListOfBeers() {return listOfBeers;}

    public void setListOfBeers(List<Beer> listOfBeers) {this.listOfBeers = listOfBeers;}
}
