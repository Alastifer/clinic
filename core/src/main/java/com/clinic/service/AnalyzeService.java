package com.clinic.service;

import com.clinic.model.Analyze;

import java.util.List;

public interface AnalyzeService {
    List<Analyze> getAnalyzes(String username) throws IllegalArgumentException;
    Analyze getAnalyze(Long id, String username) throws IllegalArgumentException;
}
