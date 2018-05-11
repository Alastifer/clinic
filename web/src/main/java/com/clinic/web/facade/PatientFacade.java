package com.clinic.web.facade;

import com.clinic.web.model.PatientModel;

import java.util.List;

public interface PatientFacade {
    PatientModel getPatientByUsername(String username);
    List<PatientModel> getAllPatients();
}
