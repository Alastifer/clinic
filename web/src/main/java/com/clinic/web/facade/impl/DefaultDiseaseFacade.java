package com.clinic.web.facade.impl;

import com.clinic.model.Disease;
import com.clinic.service.DiseaseService;
import com.clinic.web.facade.DiseaseFacade;
import com.clinic.web.model.DiseaseModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultDiseaseFacade implements DiseaseFacade {
    @Resource
    private DiseaseService diseaseService;

    @Override
    public List<DiseaseModel> getDiseases(String username) {
        List<Disease> diseases = diseaseService.getDiseases(username);
        List<DiseaseModel> diseaseModels = new ArrayList<>();
        diseases.forEach(disease -> {
            DiseaseModel diseaseModel = new DiseaseModel();
            diseaseModel.setId(disease.getId());
            diseaseModel.setUsername(disease.getUsername());
            diseaseModel.setBeginDate(disease.getBeginDate());
            diseaseModel.setEndDate(disease.getEndDate());
            diseaseModel.setType(disease.getType());
            diseaseModel.setContent(disease.getContent());
            diseaseModels.add(diseaseModel);
        });

        return diseaseModels;
    }
}
