package com.clinic.service.impl;

import com.clinic.dao.PatientDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultPatientService implements PatientService {
    @Resource
    private PatientDAO patientDAO;

    @Override
    public Patient getPatientByUsername(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException("Username must not be null");
        }

        try {
            return patientDAO.getPatientByUsername(username);
        } catch (AmbiguousIdentifierException | UnknownIdentifierException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
