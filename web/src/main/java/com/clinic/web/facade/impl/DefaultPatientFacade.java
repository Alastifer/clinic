package com.clinic.web.facade.impl;

import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import com.clinic.web.model.PatientModel;
import com.clinic.web.facade.PatientFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultPatientFacade implements PatientFacade {
    @Resource
    private PatientService patientService;

    @Override
    public PatientModel getPatientByUsername(String username) {
        Patient patient = patientService.getPatientByUsername(username);
        PatientModel patientModel = new PatientModel();

        patientModel.setUsername(patient.getUsername());
        patientModel.setAddress(patient.getAddress());
        patientModel.setBirthDay(patient.getBirthDay());
        patientModel.setFirstName(patient.getFirstName());
        patientModel.setLastName(patient.getLastName());
        patientModel.setPhoneNumber(patient.getPhoneNumber());
        return patientModel;
    }
}
