package com.clinic.web.model;

import com.clinic.web.validate.DiseaseType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class DiseaseModel {
    private Long id;

    private PatientModel patient;

    @NotEmpty(message = "{diseaseModel.beginDate.empty}")
    @Pattern(regexp = "(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))-(?:19|20)[0-9]{2} (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])", message = "{diseaseModel.beginDate.invalid}")
    private String beginDate;

    @NotEmpty(message = "{diseaseModel.endDate.empty}")
    @Pattern(regexp = "(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))-(?:19|20)[0-9]{2} (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])", message = "{diseaseModel.endDate.invalid}")
    private String endDate;

    @NotEmpty(message = "{diseaseModel.type.empty}")
    @DiseaseType(message = "{diseaseModel.type.incorrect}")
    private String type;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
}
