package com.clinic.service.impl;

import com.clinic.dao.EmployeeDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Employee;
import com.clinic.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefaultEmployeeService implements EmployeeService {
    @Resource
    private EmployeeDAO employeeDAO;

    @Override
    public Employee getEmployeeByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username must not be null");
        }

        try {
            return employeeDAO.getEmployeeByUsername(username);
        } catch (AmbiguousIdentifierException | UnknownIdentifierException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
