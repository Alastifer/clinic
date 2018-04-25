package com.clinic.web.facade.impl;

import com.clinic.model.Employee;
import com.clinic.service.EmployeeService;
import com.clinic.web.dto.EmployeeData;
import com.clinic.web.facade.EmployeeFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultEmployeeFacade implements EmployeeFacade {
    @Resource
    private EmployeeService employeeService;

    @Override
    public EmployeeData getEmployee(String username) {
        Employee employee = employeeService.getEmployee(username);
        EmployeeData employeeData = new EmployeeData();

        employeeData.setUsername(employee.getUsername());
        employeeData.setFirstName(employee.getFirstName());
        employeeData.setLastName(employee.getLastName());
        employeeData.setPosition(employee.getPosition());
        return employeeData;
    }
}
