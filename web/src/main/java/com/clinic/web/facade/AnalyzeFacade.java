package com.clinic.web.facade;

import com.clinic.web.model.AnalyzeModel;

import java.util.List;

public interface AnalyzeFacade {
    List<AnalyzeModel> getAnalyzes(String username);
    AnalyzeModel getAnalyze(Long id, String username);
}
