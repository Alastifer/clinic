package com.clinic.service.impl;

import com.clinic.dao.TicketDAO;
import com.clinic.model.Ticket;
import com.clinic.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultTicketService implements TicketService {
    @Resource
    private TicketDAO ticketDAO;

    @Override
    public List<Ticket> getTickets(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException();
        }

        return ticketDAO.getAllTicketsByUsername(username);
    }

    @Override
    public void cancelTicket(Long id, String username) throws IllegalArgumentException {
        if (id == null || username == null) {
            throw new IllegalArgumentException();
        }

        ticketDAO.cancelTicketByIdAndUsername(id, username);
    }
}
