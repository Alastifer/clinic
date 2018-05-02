package com.clinic.web.controller.patient;

import com.clinic.web.facade.TicketFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class TicketController {
    @Resource
    private TicketFacade ticketFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_TICKETS = "tickets";

    @GetMapping("/patient/tickets")
    public String getTickets(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_TICKETS, ticketFacade.getTickets(username));
        return "/patient/ticketsList";
    }

    @PostMapping(value = "/patient/tickets", params = "ticketForCancel")
    public String cancelTicket(@RequestParam Long ticketForCancel) {
        return null;
    }
}
