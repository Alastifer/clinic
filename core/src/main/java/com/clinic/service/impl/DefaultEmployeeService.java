package com.clinic.service.impl;

import com.clinic.dao.EmployeeDAO;
import com.clinic.model.Employee;
import com.clinic.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DefaultEmployeeService implements EmployeeService {
    @Resource
    private EmployeeDAO employeeDAO;

    @Override
    public Employee getEmployee(String username) throws IllegalArgumentException {
        Optional<Employee> employee = employeeDAO.getEmployee(username);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
