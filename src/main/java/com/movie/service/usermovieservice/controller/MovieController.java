package com.movie.service.usermovieservice.controller;

import com.movie.service.usermovieservice.bean.MovieBean;
import com.movie.service.usermovieservice.bean.RatingBean;
import com.movie.service.usermovieservice.bean.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")

public class MovieController {

    @Autowired

    RestTemplate restTemplate;

    @Autowired
    RatingResorces ratingResorces;

    @Autowired

    MovieResources movieResources;
    @GetMapping("/getMovies/{userId}")


    public ResponseData getMovieAndRatingList(@PathVariable("userId") String userId) {
        MovieBean userMovie = movieResources.getMovieData(userId);
        RatingBean ratingBean = ratingResorces.getRatinData(userMovie);
        ResponseData responseData = new ResponseData();
        responseData.setMovies(userMovie);
        responseData.setRatings(ratingBean);
        responseData.setStatus("Success");
        return responseData;
    }




}