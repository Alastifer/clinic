package com.clinic.web.controller;

import com.clinic.web.facade.AnalyzeFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AnalyzeController {
    @Resource
    private AnalyzeFacade analyzeFacade;

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
}
