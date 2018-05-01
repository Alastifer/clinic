package com.clinic.web.model;

import java.sql.Timestamp;

public class AnalyzeModel {
    private Long id;
    private Timestamp receivingDate;
    private String type;
    private String content;
    private PatientModel patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Timestamp receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
}
