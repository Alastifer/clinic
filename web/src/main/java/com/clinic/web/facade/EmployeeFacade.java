package com.clinic.web.facade;

import com.clinic.web.dto.EmployeeData;

public interface EmployeeFacade {
    EmployeeData getEmployee(String username);
}
