package com.clinic.web.controller.employee;

import com.clinic.web.facade.PatientFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller("employee-patientController")
public class PatientController {
    @Resource
    private PatientFacade patientFacade;

    private static final String ATTRIBUTE_PATIENT = "patient";
    private static final String ATTRIBUTE_PATIENTS = "patients";

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
