package com.clinic.web.model;

import com.clinic.web.validate.AnalyzeType;
import com.clinic.web.validate.DiseaseType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class AnalyzeModel {
    private Long id;

    @NotEmpty(message = "{analyzeModel.receivingDate.empty}")
    @Pattern(regexp = "(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))-(?:19|20)[0-9]{2} (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])", message = "{analyzeModel.receivingDate.invalid}")
    private String receivingDate;

    @NotEmpty(message = "{analyzeModel.type.empty}")
    @AnalyzeType(message = "{analyzeModel.type.incorrect}")
    private String type;

    private String content;
    private PatientModel patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
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
