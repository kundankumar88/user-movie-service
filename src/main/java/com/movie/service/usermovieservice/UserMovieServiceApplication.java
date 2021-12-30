package com.movie.service.usermovieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//server port 8080
@SpringBootApplication
@EnableCircuitBreaker
public class UserMovieServiceApplication {

	@Bean

@LoadBalanced
	public RestTemplate getTemplate()
	{
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserMovieServiceApplication.class, args);
	}

}
