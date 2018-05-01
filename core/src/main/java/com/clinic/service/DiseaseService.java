package com.clinic.service;

import com.clinic.model.Disease;

import java.util.List;

public interface DiseaseService {
    List<Disease> getDiseases(String username) throws IllegalArgumentException;
    Disease getDisease(Long id, String username) throws IllegalArgumentException;
}
