package com.techjava.ticketbooking;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techjava.ticketbooking.model.Ticket;
@RestController
public class TicketBookingRestClient {
   @Autowired
   RestTemplate restTemplate;
//restservice client // consumer application

	public void getTicketDetails() {
		
	final String uri = "http://localhost:8085/booking/getTicketById/7";
    
	RestTemplate restTemplate = new RestTemplate();
    
    
    HttpHeaders headers = new HttpHeaders();
   HttpEntity <String> entity = new HttpEntity<String>(headers);
    
     ResponseEntity<Ticket> response = restTemplate.getForEntity(uri, Ticket.class);
   //  System.out.println(response.getBody().toString());
     
    System.out.println(restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody().toString());
   
     
     // restTemplate.exchange("http://localhost:8085/booking/", HttpMethod.POST, entity, String.class).getBody();
   //restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
   //restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
   
	}
	public static void main(String[] args) {
		TicketBookingRestClient client= new TicketBookingRestClient();
		client.getTicketDetails();
	}
}
/*
Rest Template is used to create applications that consume RESTful Web Services. 
You can use the exchange() method to consume the web services for all HTTP methods. 

To consume the API −

Autowired the Rest Template Object.
Use HttpHeaders to set the Request Headers.
Use HttpEntity to wrap the request object.
Provide the URL, HttpMethod, and Return type for Exchange() method.

 Spring introduced a new HTTP client called WebClient.

WebClient is a modern, alternative HTTP client to RestTemplate. Not only does it provide a traditional synchronous 
API, but it also supports an efficient nonblocking and asynchronous approach.

RestTemplate restTemplate = new RestTemplate();
String fooResourceUrl
  = "http://localhost:8080/spring-rest/foos";
ResponseEntity<String> response
  = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

*/