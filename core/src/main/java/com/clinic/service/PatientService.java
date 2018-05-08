package com.clinic.service;

import com.clinic.model.Patient;

public interface PatientService {
    Patient getPatientByUsername(String username) throws IllegalArgumentException;
}
