package com.movie.service.usermovieservice.controller;

import com.movie.service.usermovieservice.bean.MovieBean;
import com.movie.service.usermovieservice.bean.RatingBean;
import com.movie.service.usermovieservice.bean.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @GetMapping("/getMovies/{userId}")
    public ResponseData getMovieAndRatingList(@PathVariable("userId") String userId) {



       MovieBean userMovie= restTemplate.getForObject("http://MOVIE-SERVICE-ENDPOINT/movie/"+userId, MovieBean.class);  //Get The Movie Info
        RatingBean ratingBean= restTemplate.getForObject("http://RATING-SERVICE-ENDPOINT/ratings/"+userMovie.getId(), RatingBean.class);
       ResponseData responseData=new ResponseData();
       responseData.setMovies(userMovie);
       responseData.setRatings(ratingBean);
       responseData.setStatus("Success");
       return responseData;
    }


}
