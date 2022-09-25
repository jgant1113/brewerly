package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
public class JdbcProfileDao implements ProfileDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findType(String username) {
        String sql = "SELECT * FROM profiles WHERE username = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        if(results.next()){
            Profile profile = mapRowToProfile(results);
            return profile.getProfileType();
        } else {
            throw new RuntimeException("Profile of user "+username+" was not found.");
        }
    }

    @Override
    public void createProfile(String username, String profileType) {

        String sql = "INSERT INTO profiles (username, profile_type) values (?,?)";
        jdbcTemplate.update(sql, username, profileType);

    }

    public Profile mapRowToProfile(SqlRowSet rs){
        Profile profile = new Profile();
        profile.setUsername(rs.getString("username"));
        profile.setProfileType(rs.getString("profile_type"));
        return profile;
    }
}
