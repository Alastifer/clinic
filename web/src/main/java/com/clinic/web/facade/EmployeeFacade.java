package com.clinic.web.facade;

import com.clinic.web.model.EmployeeModel;

public interface EmployeeFacade {
    EmployeeModel getEmployeeByUsername(String username);
}
