package com.clinic.service.impl;

import com.clinic.dao.PatientDAO;
import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DefaultPatientService implements PatientService {
    @Resource
    private PatientDAO patientDAO;

    @Override
    public Patient getPatient(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException();
        }

        Optional<Patient> patient = patientDAO.getPatient(username);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
