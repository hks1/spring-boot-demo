package com.example.springdata.tennisplayer;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public int updatePlayer(Player player){
        String sql = "UPDATE PLAYER " +
                "SET Name = ?, Nationality = ?, Birth_Date = ?, Titles = ? " +
                "WHERE ID = ?";

        return jdbcTemplate.update(sql, new Object[] {
                player.getName(),
                player.getNationality(),
                player.getBirthDate(),
                player.getTitles(),
                player.getId()
        });
    }

    public int deletePlayerById(int id){
        String sql = "DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }

    // Create table query
    public void createTournamentTable(){
        String sql = "CREATE TABLE TOURNAMENT " +
                "(ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }

    // RowMapper interface
    // custom row mapper
    //The custom row mapper, PlayerMapper is created as an inner class because it will only be used inside JdbcPlayerDao.
    // It is best practice to make it static and final.
    //The PlayerMapper class is reusable and can be used in all methods of the PlayerDao class to map rows from the Player table to the Player bean.
    private static final class PlayerMapper implements RowMapper<Player>{

        //The Rowmapper interface has one method, mapRow, for which we will write our custom implementation to initialize a Player object.
        //This method defines how a row is mapped.
        // It takes two arguments, the first being the result set which JdbcTemplate gets after running the query and the second being the row number.
        //To use PlayerMapper, we can simply pass it in any method instead of the BeanPropertyRowMapper.
        @Override
        public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("Id"));
            player.setName(resultSet.getString("Name"));
            player.setNationality(resultSet.getString("Nationality"));
            player.setBirthDate(resultSet.getTime("Birth_Date"));
            player.setTitles(resultSet.getInt("Titles"));
            return player;
        }



    }

    //method to find players based on their nationality
    // using our custom mapper to convert the result set to objects as follows:
    public List<Player> getPlayerByNationality(String nationality){
        String sql = "SELECT * FROM PLAYER WHERE Nationality = ?";
        return jdbcTemplate.query(sql, new PlayerMapper(), new Object[] {nationality});
    }

}
