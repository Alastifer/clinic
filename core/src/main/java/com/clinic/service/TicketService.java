package com.clinic.service;

import com.clinic.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getTickets(String username) throws IllegalArgumentException;
    void cancelTicket(Long id, String username) throws IllegalArgumentException;
}
