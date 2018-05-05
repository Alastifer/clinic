package com.clinic.web.facade.impl;

import com.clinic.model.Ticket;
import com.clinic.service.TicketService;
import com.clinic.web.facade.EmployeeFacade;
import com.clinic.web.facade.PatientFacade;
import com.clinic.web.facade.TicketFacade;
import com.clinic.web.model.TicketModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultTicketFacade implements TicketFacade {
    @Resource
    private TicketService ticketService;

    @Resource
    private EmployeeFacade employeeFacade;

    @Resource
    private PatientFacade patientFacade;

    @Override
    public List<TicketModel> getTickets(String username) {
        List<Ticket> tickets = ticketService.getTickets(username);
        List<TicketModel> ticketModels = new ArrayList<>();
        tickets.forEach(ticket -> {
            TicketModel ticketModel = createModel(ticket);
            ticketModels.add(ticketModel);
        });

        return ticketModels;
    }

    @Override
    public void cancelTicket(Long id) {
        ticketService.cancelTicket(id);
    }

    private TicketModel createModel(Ticket ticket) {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setId(ticket.getId());
        ticketModel.setReceiptDate(ticket.getReceiptDate());
        ticketModel.setRoom(ticket.getRoom());
        ticketModel.setPatient(patientFacade.getPatient(ticket.getPatientUsername()));
        ticketModel.setEmployee(employeeFacade.getEmployee(ticket.getEmployeeUsername()));
        return ticketModel;
    }
}
