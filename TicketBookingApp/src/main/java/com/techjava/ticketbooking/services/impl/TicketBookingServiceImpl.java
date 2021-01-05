package com.techjava.ticketbooking.services.impl;

import com.techjava.ticketbooking.dao.TicketBookingJpaDao;
import com.techjava.ticketbooking.model.Ticket;
import com.techjava.ticketbooking.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class TicketBookingServiceImpl implements TicketBookingService{

    @Autowired
    private TicketBookingJpaDao ticketBookingJpaDao;


    @Override
    public Ticket findTicketByEmail(String email) {
        return ticketBookingJpaDao.findByEmail(email);
    }

    @Override
    public Iterable<Ticket> getAllTickets() {
        return ticketBookingJpaDao.findAll();
    }

    //Optional --java8  
    //
    @Override
    public Ticket findTicketById(Integer ticketId) {
        return ticketBookingJpaDao.findById(ticketId).get();  //Optional 
    }

    @Override
    public Ticket updateEmailById(Integer ticketId, String email) {
        Ticket ticket = ticketBookingJpaDao.findById(ticketId).get();
        ticket.setEmail(email);
        return ticketBookingJpaDao.save(ticket);
    }

    @Override
    public boolean deleteTicketById(Integer ticketId) {
       
        Ticket ticket = ticketBookingJpaDao.findById(ticketId).get();
        if(ticket==null){
            return false;
        }
        ticketBookingJpaDao.deleteById(ticketId);
        return true;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketBookingJpaDao.save(ticket);
    }
}
