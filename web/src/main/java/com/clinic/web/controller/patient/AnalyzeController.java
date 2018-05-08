package com.clinic.web.controller.patient;

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
}
