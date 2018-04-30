package com.clinic.web.facade;

import com.clinic.web.model.DiseaseModel;

import java.util.List;

public interface DiseaseFacade {
    List<DiseaseModel> getDiseases(String username);
}
