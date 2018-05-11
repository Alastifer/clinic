package com.clinic.service;

import com.clinic.model.Disease;

import java.util.List;

public interface DiseaseService {
    List<Disease> getAllDiseasesByUsername(String username);
    Disease getDiseaseByIdAndUsername(Long id, String username);
}
