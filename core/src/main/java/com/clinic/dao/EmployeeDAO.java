package com.clinic.dao;

import com.clinic.model.Employee;

import java.util.Optional;

public interface EmployeeDAO {
    Optional<Employee> getEmployee(String username);
}
