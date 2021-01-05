package com.techjava.ticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
