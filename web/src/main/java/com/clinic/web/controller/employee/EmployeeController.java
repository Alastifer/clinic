package com.clinic.web.controller.employee;

import com.clinic.web.facade.EmployeeFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeFacade employeeFacade;

    @Resource
    private HttpSession session;

    private static final String ATTRIBUTE_USERNAME = "username";
    private static final String ATTRIBUTE_EMPLOYEE = "employee";

    @GetMapping("/employee")
    public String getEmployee(Model model) {
        final String username = (String) session.getAttribute(ATTRIBUTE_USERNAME);
        model.addAttribute(ATTRIBUTE_EMPLOYEE, employeeFacade.getEmployee(username));
        return "employee";
    }
}
