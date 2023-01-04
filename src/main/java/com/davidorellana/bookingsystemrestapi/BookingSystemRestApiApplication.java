package com.davidorellana.bookingsystemrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BookingSystemRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingSystemRestApiApplication.class, args);
	}

}
