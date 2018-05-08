package com.clinic.service;

import com.clinic.model.Analyze;

import java.util.List;

public interface AnalyzeService {
    List<Analyze> getAllAnalyzesByUsername(String username) throws IllegalArgumentException;
    Analyze getAnalyzeByIdAndUsername(Long id, String username) throws IllegalArgumentException;
}
