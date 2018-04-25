package com.clinic.web.facade;

import com.clinic.web.dto.PatientData;

public interface PatientFacade {
    PatientData getPatient(String username);
}
