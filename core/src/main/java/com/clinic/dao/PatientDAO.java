package com.clinic.dao;

import com.clinic.model.Patient;

import java.util.List;

public interface PatientDAO {
    Patient getPatientByUsername(String username);
    List<Patient> getAllPatients();
}
