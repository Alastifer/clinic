package com.clinic.dao;

import com.clinic.model.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseDAO {
    List<Disease> getAllDiseasesByUsername(String username);
    Disease getDiseaseByIdAndUsername(Long id, String username);
    List<String> getAllDiseaseTypes();
    void save(Disease disease);
    void remove(Long id);
}
