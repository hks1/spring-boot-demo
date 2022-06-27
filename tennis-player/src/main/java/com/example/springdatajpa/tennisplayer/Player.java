package com.example.springdatajpa.tennisplayer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.Table;


//The Spring Boot autoconfiguration triggers a schema update and creates a table by the same name as the class marked with the @Entity annotation.
// When using JPA, we do not need to create a table.
// We will comment out the table creation query in schema.sql as it is not needed anymore.
@Entity
@Table(name="Player")
public class Player {
    @Id
    @GeneratedValue
    private  int id;
    private String name;

    @Column(name="nationality")
    private String nationality;
    private Date birthDate;
    private int titles;

    public Player(){}

    public Player(int id, String name, String nationality, Date birthDate, int titles){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    // Constructor without Id attribute
    public Player(String name, String nationality, Date birthDate, int titles){
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", titles=" + titles +
                '}';
    }
}
