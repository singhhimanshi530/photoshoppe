package com.techjava.ticketbooking.controller;

import com.techjava.ticketbooking.model.Ticket;
import com.techjava.ticketbooking.services.TicketBookingService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class TicketBookingController {

	 private static final Logger logger = LogManager.getLogger(TicketBookingController.class);

    @Autowired
    private TicketBookingService ticketBookingService;

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets(){
    	logger.info(" in controller..");
        return (List<Ticket>) ticketBookingService.getAllTickets();
    }

    @GetMapping("/getTicketById/{ticketId}")
    public Ticket getTicketById(@PathVariable Integer ticketId){
        return ticketBookingService.findTicketById(ticketId);
    }

    @GetMapping("/getTicketByEmail/{email:.+}")
    public Ticket getTicketByEmail(@PathVariable String email){
        return ticketBookingService.findTicketByEmail(email);
    }

    @PutMapping("/updateTicketbyId/{email:.+}/ticket/{ticketId}")
    public Ticket updateTicketById(@PathVariable String email, @PathVariable Integer ticketId){
        return ticketBookingService.updateEmailById(ticketId, email);
    }
/*
 * 
 { 
     "ticketId":"101",
   "passengerName":"Abc",
   "fromStation":"Hyd",
    "toStation":"Chennai",
   "bookingDate":"2019-09-09",
     "email":"abc@gmail.com"
	
	}
 */
    @PostMapping("/createTicket")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketBookingService.createTicket(ticket);
    }

    @DeleteMapping("/deleteTicketById/ticket/{ticketId}")
    public boolean deleteTicketById(@PathVariable Integer ticketId){
        return ticketBookingService.deleteTicketById(ticketId);
    }

}
