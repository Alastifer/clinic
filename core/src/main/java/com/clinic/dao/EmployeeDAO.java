package com.clinic.dao;

import com.clinic.model.Employee;

public interface EmployeeDAO {
    Employee getEmployeeByUsername(String username);
}
