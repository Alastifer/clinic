package com.clinic.web.facade;

import com.clinic.web.model.AnalyzeModel;

import java.util.List;

public interface AnalyzeFacade {
    List<AnalyzeModel> getAllAnalyzesByUsername(String username);
    AnalyzeModel getAnalyzeByIdAndUsername(Long id, String username);
}
