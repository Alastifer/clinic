package com.clinic.service;

import com.clinic.model.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientByUsername(String username);
    List<Patient> getAllPatients();
}
