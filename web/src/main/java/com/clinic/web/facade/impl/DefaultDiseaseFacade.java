package com.clinic.web.facade.impl;

import com.clinic.model.Disease;
import com.clinic.service.DiseaseService;
import com.clinic.web.facade.DiseaseFacade;
import com.clinic.web.facade.PatientFacade;
import com.clinic.web.model.DiseaseModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    private DiseaseModel createModel(Disease disease) {
        DiseaseModel diseaseModel = new DiseaseModel();
        diseaseModel.setId(disease.getId());
        diseaseModel.setPatient(patientFacade.getPatientByUsername(disease.getUsername()));
        diseaseModel.setBeginDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(disease.getBeginDate()));
        diseaseModel.setEndDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(disease.getEndDate()));
        diseaseModel.setType(disease.getType());
        diseaseModel.setContent(disease.getContent());
        return diseaseModel;
    }
}
