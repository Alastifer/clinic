package com.clinic.dao;

import com.clinic.model.Patient;

public interface PatientDAO {
    Patient getPatientByUsername(String username);
}
