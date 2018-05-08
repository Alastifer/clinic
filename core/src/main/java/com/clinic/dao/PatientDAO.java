package com.clinic.dao;

import com.clinic.model.Patient;

import java.util.Optional;

public interface PatientDAO {
    Optional<Patient> getPatientByUsername(String username);
}
