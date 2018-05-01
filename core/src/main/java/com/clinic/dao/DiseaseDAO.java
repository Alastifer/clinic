package com.clinic.dao;

import com.clinic.model.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseDAO {
    List<Disease> getDiseases(String username);
    Optional<Disease> getDisease(Long id, String username);
}
