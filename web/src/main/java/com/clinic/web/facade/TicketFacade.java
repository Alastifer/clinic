package com.clinic.web.facade;

import com.clinic.web.model.TicketModel;

import java.util.List;

public interface TicketFacade {
    List<TicketModel> getAllTicketsByUsername(String username);
    void cancelTicketByIdAndUsername(Long id, String username);
}
