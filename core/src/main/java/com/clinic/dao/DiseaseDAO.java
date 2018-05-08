package com.clinic.dao;

import com.clinic.model.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseDAO {
    List<Disease> getAllDiseasesByUsername(String username);
    Optional<Disease> getDiseaseByIdAndUsername(Long id, String username);
}
