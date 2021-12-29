package com.movie.service.usermovieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//server port 8080
@SpringBootApplication
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
