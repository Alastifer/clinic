package com.clinic.dao;

import com.clinic.model.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> getTickets(String username);
    void cancelTicket(Long id);
}
