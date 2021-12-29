package com.movie.service.usermovieservice.bean;

public class RatingBean {

    private int movieId;
    private int ratings;
    private String comments;

    public RatingBean(int movieId, int ratings, String comments) {
        this.movieId = movieId;
        this.ratings = ratings;
        this.comments = comments;
    }

    public RatingBean() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
