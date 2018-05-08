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
    public Employee getEmployeeByUsername(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException();
        }

        Optional<Employee> employee = employeeDAO.getEmployeeByUsername(username);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
