package com.clinic.service;

import com.clinic.model.Employee;

public interface EmployeeService {
    Employee getEmployee(String username) throws IllegalArgumentException;
}
