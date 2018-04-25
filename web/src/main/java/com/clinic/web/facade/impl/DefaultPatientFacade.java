package com.clinic.web.facade.impl;

import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import com.clinic.web.dto.PatientData;
import com.clinic.web.facade.PatientFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultPatientFacade implements PatientFacade {
    @Resource
    private PatientService patientService;

    @Override
    public PatientData getPatient(String username) {
        Patient patient = patientService.getPatient(username);
        PatientData patientData = new PatientData();

        patientData.setUsername(patient.getUsername());
        patientData.setAddress(patient.getAddress());
        patientData.setBirthDay(patient.getBirthDay());
        patientData.setFirstName(patient.getFirstName());
        patientData.setLastName(patient.getLastName());
        patientData.setPhoneNumber(patient.getPhoneNumber());
        return patientData;
    }
}
