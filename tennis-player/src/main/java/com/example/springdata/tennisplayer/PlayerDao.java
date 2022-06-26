package com.example.springdata.tennisplayer;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {

    // autowire the JdbcTemplate in the PlayerDao class
    @Autowired
    JdbcTemplate jdbcTemplate;

    // A row mapper is used to match the data coming from the database to the attributes of the bean.
    // The BeanPropertyRowMapper is the default row mapper defined by Spring.
    public List<Player> getAllPlayer(){
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    // Select with a WHERE clause
    public Player getPlayerById(int id){
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";

        //If we search by the primary key, we will get one row back.
        // In this case, instead of using the query method, we will use the queryForObject method of JdbcTemplate.
        // This method accepts a list of parameters.
        // We will create a list of objects and pass it to the method.
        // The parameter id will be substituted in the query and a Player object is returned.
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Player>(Player.class),
                new Object[] {id});
    }

    public int insertPlayer(Player player){
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_Date, Titles) " +
                "VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[]
                { player.getId(), player.getName(), player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()),
                        player.getTitles()
                });
    }

}
