package com.movie.service.usermovieservice.bean;

public class ResponseData {

    String status;
    MovieBean movies;
    RatingBean ratings;

    public RatingBean getRatings() {
        return ratings;
    }

    public void setRatings(RatingBean ratings) {
        this.ratings = ratings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MovieBean getMovies() {
        return movies;
    }

    public void setMovies(MovieBean movies) {
        this.movies = movies;
    }
}
