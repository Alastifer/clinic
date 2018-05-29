package com.clinic.web.facade.impl;

import com.clinic.model.Disease;
import com.clinic.service.DiseaseService;
import com.clinic.web.facade.DiseaseFacade;
import com.clinic.web.facade.PatientFacade;
import com.clinic.web.model.DiseaseModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DefaultDiseaseFacade implements DiseaseFacade {
    @Resource
    private DiseaseService diseaseService;

    @Resource
    private PatientFacade patientFacade;

    @Override
    public List<DiseaseModel> getAllDiseasesByUsername(String username) {
        List<Disease> diseases = diseaseService.getAllDiseasesByUsername(username);
        List<DiseaseModel> diseaseModels = new ArrayList<>();
        diseases.forEach(disease -> {
            DiseaseModel diseaseModel = createModel(disease);
            diseaseModels.add(diseaseModel);
        });

        return diseaseModels;
    }

    @Override
    public DiseaseModel getDiseaseByIdAndUsername(Long id, String username) {
        Disease disease = diseaseService.getDiseaseByIdAndUsername(id, username);
        return createModel(disease);
    }

    @Override
    public void save(DiseaseModel diseaseModel) {
        Disease disease = new Disease();
        disease.setUsername(diseaseModel.getPatient().getUsername());
        disease.setBeginDate(convertToTimestamp(diseaseModel.getBeginDate() + ":00"));
        disease.setEndDate(convertToTimestamp(diseaseModel.getEndDate() + ":00"));
        disease.setType(diseaseModel.getType());
        disease.setContent(diseaseModel.getContent());
        diseaseService.save(disease);
    }

    private DiseaseModel createModel(Disease disease) {
        DiseaseModel diseaseModel = new DiseaseModel();
        diseaseModel.setId(disease.getId());
        diseaseModel.setPatient(patientFacade.getPatientByUsername(disease.getUsername()));
        diseaseModel.setBeginDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(disease.getBeginDate()));
        diseaseModel.setEndDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(disease.getEndDate()));
        diseaseModel.setType(disease.getType());
        diseaseModel.setContent(disease.getContent());
        return diseaseModel;
    }

    private Timestamp convertToTimestamp(String dateString) {
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }

        dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return Timestamp.valueOf(dateString);
    }
}
