package com.restaurant.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing // Enable automatic date tracking

public class RestaurantPosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantPosApplication.class, args);
		System.out.println("Application Running...");
		
	}

}

