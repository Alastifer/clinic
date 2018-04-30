package com.clinic.web.facade;

import com.clinic.web.model.PatientModel;

public interface PatientFacade {
    PatientModel getPatient(String username);
}
