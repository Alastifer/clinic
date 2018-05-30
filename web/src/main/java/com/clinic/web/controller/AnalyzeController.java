package com.clinic.web.controller;

import com.clinic.web.facade.AnalyzeFacade;
import com.clinic.web.facade.PatientFacade;
import com.clinic.web.model.AnalyzeModel;
import com.clinic.web.model.DiseaseModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AnalyzeController {
    @Resource
    private AnalyzeFacade analyzeFacade;

    @Resource
    private PatientFacade patientFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_ANALYZES = "analyzes";
    private static final String ATTRIBUTE_ANALYZE = "analyze";

    @GetMapping("/patient/analyzes")
    public String getAnalyzes(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_ANALYZES, analyzeFacade.getAllAnalyzesByUsername(username));
        return "patient/analyzesList";
    }

    @GetMapping("/patient/analyzes/{id}")
    public String getAnalyze(@PathVariable Long id, Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_ANALYZE, analyzeFacade.getAnalyzeByIdAndUsername(id, username));
        return "patient/analyze";
    }

    @GetMapping("/employee/patients/{username}/analyzes")
    public String getAnalyze(@PathVariable String username,
                             Model model) {
        model.addAttribute(ATTRIBUTE_ANALYZES, analyzeFacade.getAllAnalyzesByUsername(username));
        return "employee/analyzesList";
    }

    @GetMapping("/employee/patients/{username}/analyzes/{id}")
    public String getAnalyzes(@PathVariable String username,
                             @PathVariable Long id,
                             Model model) {
        model.addAttribute(ATTRIBUTE_ANALYZE, analyzeFacade.getAnalyzeByIdAndUsername(id, username));
        return "employee/analyze";
    }

    @GetMapping("/employee/patients/{username}/analyzes/add")
    public String addAnalyze(@PathVariable String username,
                             Model model) {
        AnalyzeModel analyzeModel = new AnalyzeModel();
        analyzeModel.setPatient(patientFacade.getPatientByUsername(username));
        model.addAttribute(ATTRIBUTE_ANALYZE, analyzeModel);
        return "employee/addAnalyze";
    }

    @PostMapping("/employee/patients/{username}/analyzes/add")
    public String addDisease(@Valid @ModelAttribute("analyze") AnalyzeModel analyzeModel,
                             BindingResult bindingResult,
                             @PathVariable String username) {
        analyzeModel.setPatient(patientFacade.getPatientByUsername(username));

        if (bindingResult.hasErrors()) {
            return "employee/addAnalyze";
        }

        analyzeFacade.save(analyzeModel);
        return "redirect:/employee/patients/" + username + "/analyzes";
    }

    @GetMapping("/employee/patients/{username}/analyzes/delete")
    public String showAnalyzesForDelete(@PathVariable String username, Model model) {
        model.addAttribute(ATTRIBUTE_ANALYZES, analyzeFacade.getAllAnalyzesByUsername(username));
        return "employee/deleteAnalyze";
    }

    @PostMapping("/employee/patients/{username}/analyzes/{analyzeId}/delete")
    public String deleteAnalyze(@PathVariable String username,
                                @PathVariable Long analyzeId) {
        analyzeFacade.delete(analyzeId);
        return "redirect:/employee/patients/" + username + "/analyzes/delete";
    }
}
