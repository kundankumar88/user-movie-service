package com.movie.service.usermovieservice.controller;

import com.movie.service.usermovieservice.bean.MovieBean;
import com.movie.service.usermovieservice.bean.RatingBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RatingResorces {

    @Autowired
    RestTemplate restTemplate;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @HystrixCommand(fallbackMethod = "fallbackMethodCallForRatings",
    commandProperties = {
           /* @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10" )*/
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")

    }
    )
    public  RatingBean getRatinData(MovieBean userMovie) {
        logger.info("..Inside getRatinData method");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
           /* e.printStackTrace();*/
        }
       // logger.info("..Crossed Timed out statements");
        RatingBean ratingBean = restTemplate.getForObject("http://RATING-SERVICE-ENDPOINT/ratings/" + userMovie.getId(), RatingBean.class);
        logger.info("..Crossed Timed out statements");
        return ratingBean;
    }


    public  RatingBean fallbackMethodCallForRatings(MovieBean userMovie) {

        logger.info("..Inside fallbackMethodCallForRatings method");

        RatingBean ratingBean=new RatingBean();
        ratingBean.setRatings(0);
        ratingBean.setComments("Fallback Ratings  Comments");
        return ratingBean;

    }



}
