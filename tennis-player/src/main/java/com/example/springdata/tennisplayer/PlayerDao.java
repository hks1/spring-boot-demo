package com.example.springdata.tennisplayer;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotations.Autowired;

import java.util.List;

@Repository
public class PlayerDao {

    // autowire the JdbcTemplate in the PlayerDao class
    @Autowired
    JdbcTemplate jdbcTemplate;

    // A  is used to match the data coming from the database to the attributes of the bean.
    // The BeanPropertyRowMapper is the default row mapper defined by Spring.
    public List<Player> getAllPlayer(){
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class))
    }

}
