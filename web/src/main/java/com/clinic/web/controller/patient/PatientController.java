package com.clinic.web.controller.patient;

import com.clinic.web.facade.PatientFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class PatientController {
    @Resource
    private PatientFacade patientFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_PATIENT = "patient";

    @GetMapping("/patient")
    public String getUserPage(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_PATIENT, patientFacade.getPatientByUsername(username));
        return "patient/patient";
    }
}
