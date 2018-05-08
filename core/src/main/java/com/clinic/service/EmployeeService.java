package com.clinic.service;

import com.clinic.model.Employee;

public interface EmployeeService {
    Employee getEmployeeByUsername(String username) throws IllegalArgumentException;
}
