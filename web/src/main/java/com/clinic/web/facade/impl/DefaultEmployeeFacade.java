package com.clinic.web.facade.impl;

import com.clinic.model.Employee;
import com.clinic.service.EmployeeService;
import com.clinic.web.model.EmployeeModel;
import com.clinic.web.facade.EmployeeFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultEmployeeFacade implements EmployeeFacade {
    @Resource
    private EmployeeService employeeService;

    @Override
    public EmployeeModel getEmployeeByUsername(String username) {
        Employee employee = employeeService.getEmployeeByUsername(username);
        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setUsername(employee.getUsername());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setPosition(employee.getPosition());
        return employeeModel;
    }
}
