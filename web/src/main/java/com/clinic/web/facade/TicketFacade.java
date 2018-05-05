package com.clinic.web.facade;

import com.clinic.web.model.TicketModel;

import java.util.List;

public interface TicketFacade {
    List<TicketModel> getTickets(String username);
    void cancelTicket(Long id);
}
