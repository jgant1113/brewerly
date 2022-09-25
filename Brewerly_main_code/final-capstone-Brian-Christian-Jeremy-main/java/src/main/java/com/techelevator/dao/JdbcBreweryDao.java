package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Start of finder methods.
    //Note might need to throw an error if the list is empty, probably fine though.
    @Override
    public List<Brewery> findAll() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM breweries";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            breweries.add(mapRowToBrewery(results));
        }
        return breweries;
    }

    //Jeremy- Fixed SQL statement, now has "brewery_id" to allow proper query
    @Override
    public Brewery findBreweryById(long breweryId) {
        String sql = "SELECT * FROM breweries WHERE brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        if(results.next()){
            return mapRowToBrewery(results);
        } else {
            throw new RuntimeException("breweryId "+breweryId+" was not found.");
        }
    }

    @Override
    public Brewery findBreweryByCity(String city) {
        String sql = "SELECT * FROM breweries WHERE city = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
        if(results.next()){
            return mapRowToBrewery(results);
        } else {
            throw new RuntimeException("The city of "+city+" does not have a brewery.");
        }
    }



    @Override
    public Brewery findBreweryByName(String breweryName) {
        for (Brewery brewery : this.findAll()) {
            if( brewery.getName().toLowerCase().equals(breweryName.toLowerCase())) {
                return brewery;
            }
        } return null;


        //Little ugly, need to make the below Exception and get rid of above null.
        //throw new BreweryNotFoundException("No Brewery named " + breweryName + " was found.");
    }

//    @Override
//    public Brewery findBreweryByCity(String breweryLocation) {
//        for (Brewery brewery : this.findAll()) {
//            if( brewery.getCity().toLowerCase().equals(breweryLocation.toLowerCase())) {
//                return brewery;
//            }
//        } return null;
//        //throw new BreweryNotFoundException("No Brewery at " + breweryLocation + " was found.");
//    }

    //Works, just needs a verification for error handling.
    @Override
    public boolean createBrewery(String name, String street, String city, String state, String phonenumber, String hours_of_operation, String image_url, String history) {
        String sql = "INSERT INTO breweries (name, street, city, state, phonenumber, hours_of_operation, image_url, history) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, name, street, city, state, phonenumber, hours_of_operation, image_url, history);
        //Need a verification of sorts here.
        return true;
    }
    //End of finder methods.

    //Mapper
    //Christian - It looks like there isn't anything to map the DB brewery_id column to anything here.
    public Brewery mapRowToBrewery(SqlRowSet rs){
        Brewery brewery = new Brewery();
        brewery.setId(rs.getLong("brewery_id"));
        brewery.setName(rs.getString("name"));
        brewery.setStreet(rs.getString("street"));
        brewery.setCity(rs.getString("city"));
        brewery.setState(rs.getString("state"));
        brewery.setPhoneNumber(rs.getString("phonenumber"));
        brewery.setHoursOfOperation(rs.getString("hours_of_operation"));
        brewery.setImageUrl(rs.getString("image_url"));
        brewery.setHistory(rs.getString("history"));
        return brewery;
    }
}
