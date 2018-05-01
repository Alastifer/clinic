package com.clinic.dao;

import com.clinic.model.Analyze;

import java.util.List;
import java.util.Optional;

public interface AnalyzeDAO {
    List<Analyze> getAnalyzes(String username);
    Optional<Analyze> getAnalyze(Long id, String username);
}
