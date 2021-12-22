package com.netcracker.Movie.Model;

import javax.persistence.*;


@Entity
public class Director {

    public  Director(){
    }
    public Director(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    private String name;

    public int getTotalMovies() {
        return totalMovies;
    }

    public void setTotalMovies(int totalMovies) {
        this.totalMovies = totalMovies;
    }

    @Column
    private int totalMovies;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column
    private String gender;
}
