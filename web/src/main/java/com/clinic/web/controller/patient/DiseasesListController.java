package com.clinic.web.controller.patient;

import com.clinic.web.facade.DiseaseFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class DiseasesListController {
    @Resource
    private DiseaseFacade diseaseFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_DISEASES = "diseases";

    @GetMapping("/patient/diseases")
    public String getDiseases(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_DISEASES, diseaseFacade.getDiseases(username));
        return "patient/diseasesList";
    }
}
