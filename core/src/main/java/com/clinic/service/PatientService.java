package com.clinic.service;

import com.clinic.model.Patient;

public interface PatientService {
    Patient getPatient(String id) throws IllegalArgumentException;
}
