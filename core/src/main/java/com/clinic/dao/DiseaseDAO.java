package com.clinic.dao;

import com.clinic.model.Disease;

import java.util.List;

public interface DiseaseDAO {
    List<Disease> getAllDiseasesByUsername(String username);
}
