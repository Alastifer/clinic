package com.clinic.web.controller;

import com.clinic.web.facade.DiseaseFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class DiseaseController {
    @Resource
    private DiseaseFacade diseaseFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_DISEASES = "diseases";
    private static final String ATTRIBUTE_DISEASE = "disease";

    @GetMapping("/patient/diseases")
    public String getDiseases(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_DISEASES, diseaseFacade.getAllDiseasesByUsername(username));
        return "patient/diseasesList";
    }

    @GetMapping("/patient/diseases/{id}")
    public String getDisease(@PathVariable Long id, Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_DISEASE, diseaseFacade.getDiseaseByIdAndUsername(id, username));
        return "patient/disease";
    }

    @GetMapping("/employee/patients/{username}/diseases")
    public String getDiseasesByPatient(@PathVariable String username, Model model) {
        model.addAttribute(ATTRIBUTE_DISEASES, diseaseFacade.getAllDiseasesByUsername(username));
        return "employee/diseasesList";
    }

    @GetMapping("/employee/patients/{username}/diseases/{id}")
    public String getDisease(@PathVariable String username,
                             @PathVariable Long id,
                             Model model) {
        model.addAttribute(ATTRIBUTE_DISEASE, diseaseFacade.getDiseaseByIdAndUsername(id, username));
        return "employee/disease";
    }
}