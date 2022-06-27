package com.example.springdatajpa.tennisplayer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;

    //merge checks if the primary key value is being passed to it or not. If it finds the primary key, it updates the corresponding record.
    // If the primary key is not passed, it generates a value and inserts a new record in the table.
    public Player insertPlayer(Player player){
        return entityManager.merge(player);
    }
    //The merge method will create an SQL INSERT or UPDATE query and map values to it from the Player object on its own.
    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id){
        return entityManager.find(Player.class, id);
    }

    public void deleteById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }

}
