package com.clinic.web.controller;

import com.clinic.web.facade.EmployeeFacade;
import com.clinic.web.facade.PatientFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private EmployeeFacade employeeFacade;

    @Resource
    private PatientFacade patientFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_EMPLOYEE = "employee";
    private static final String ATTRIBUTE_PATIENT = "patient";
    private static final String ATTRIBUTE_PATIENTS = "patients";

    @GetMapping("/employee")
    public String getEmployeePage(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_EMPLOYEE, employeeFacade.getEmployeeByUsername(username));
        return "employee/employee";
    }

    @GetMapping("/patient")
    public String getPatientPage(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_PATIENT, patientFacade.getPatientByUsername(username));
        return "patient/patient";
    }

    @GetMapping("/employee/patients")
    public String getAllPatients(Model model) {
        model.addAttribute(ATTRIBUTE_PATIENTS, patientFacade.getAllPatients());
        return "employee/patientsList";
    }

    @GetMapping("/employee/patients/{username}")
    public String getPatient(@PathVariable String username, Model model) {
        model.addAttribute(ATTRIBUTE_PATIENT, patientFacade.getPatientByUsername(username));
        return "employee/patient";
    }
}
