package com.clinic.dao;

import com.clinic.model.Analyze;

import java.util.List;
import java.util.Optional;

public interface AnalyzeDAO {
    List<Analyze> getAllAnalyzesByUsername(String username);
    Optional<Analyze> getAnalyzeByIdAndUsername(Long id, String username);
}
