package com.clinic.dao;

import com.clinic.model.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> getAllTicketsByUsername(String username);
    void cancelTicketByIdAndUsername(Long id, String username);
    List<Ticket> getTicketsForOrder();
    void orderTicketByIdAndUsername(Long id, String username);
    List<Ticket> getAllTickets();
}
