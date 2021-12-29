package com.movie.service.usermovieservice.bean;

public class MovieBean {

    private String movieName;
    private String description;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovieBean(String movieName, String description) {
        this.movieName = movieName;
        this.description = description;
    }

    public MovieBean() {
    }
}
