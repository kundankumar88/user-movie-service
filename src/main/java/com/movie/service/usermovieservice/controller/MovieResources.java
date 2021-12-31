package com.movie.service.usermovieservice.controller;

import com.movie.service.usermovieservice.bean.MovieBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieResources {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallbackMethodCallForMovies")
    public MovieBean getMovieData(String userId) {
        MovieBean userMovie = restTemplate.getForObject("http://MOVIE-SERVICE-ENDPOINT/movie/" + userId, MovieBean.class);  //Get The Movie Info
        return userMovie;
    }


    public MovieBean fallbackMethodCallForMovies(String userId) {

        MovieBean movieBean =new MovieBean("None","Fallback Descriptions");
        return movieBean;

    }
}
