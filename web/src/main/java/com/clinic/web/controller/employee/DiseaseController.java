package com.clinic.web.controller.employee;

import com.clinic.web.facade.DiseaseFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller("employee-diseaseController")
public class DiseaseController {
    @Resource
    private DiseaseFacade diseaseFacade;

    private static final String ATTRIBUTE_DISEASE = "disease";
    private static final String ATTRIBUTE_DISEASES = "diseases";

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
