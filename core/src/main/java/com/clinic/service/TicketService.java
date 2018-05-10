package com.clinic.service;

import com.clinic.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTicketsByUsername(String username) throws IllegalArgumentException;
    void cancelTicketByIdAndUsername(Long id, String username) throws IllegalArgumentException;
    List<Ticket> getTicketsForOrder();
    void orderTicketByIdAndUsername(Long id, String username) throws IllegalArgumentException;
}
