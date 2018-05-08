package com.clinic.service;

import com.clinic.model.Disease;

import java.util.List;

public interface DiseaseService {
    List<Disease> getAllDiseasesByUsername(String username) throws IllegalArgumentException;
    Disease getDiseaseByIdAndUsername(Long id, String username) throws IllegalArgumentException;
}
