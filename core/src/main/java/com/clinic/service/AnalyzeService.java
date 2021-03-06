package com.clinic.service;

import com.clinic.model.Analyze;

import java.util.List;

public interface AnalyzeService {
    List<Analyze> getAllAnalyzesByUsername(String username);
    Analyze getAnalyzeByIdAndUsername(Long id, String username);
    List<String> getAllAnalyzeTypes();
    void save(Analyze analyze);
    void delete(Long id);
}
