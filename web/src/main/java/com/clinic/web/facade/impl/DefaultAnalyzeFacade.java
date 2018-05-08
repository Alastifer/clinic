package com.clinic.web.facade.impl;

import com.clinic.model.Analyze;
import com.clinic.service.AnalyzeService;
import com.clinic.web.facade.AnalyzeFacade;
import com.clinic.web.facade.PatientFacade;
import com.clinic.web.model.AnalyzeModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultAnalyzeFacade implements AnalyzeFacade {
    @Resource
    private AnalyzeService analyzeService;

    @Resource
    private PatientFacade patientFacade;

    @Override
    public List<AnalyzeModel> getAllAnalyzesByUsername(String username) {
        List<Analyze> analyzes = analyzeService.getAllAnalyzesByUsername(username);
        List<AnalyzeModel> analyzeModels = new ArrayList<>();
        analyzes.forEach(analyze ->{
            AnalyzeModel analyzeModel = createModel(analyze);
            analyzeModels.add(analyzeModel);
        });

        return analyzeModels;
    }

    @Override
    public AnalyzeModel getAnalyzeByIdAndUsername(Long id, String username) {
        Analyze analyze = analyzeService.getAnalyzeByIdAndUsername(id, username);
        return createModel(analyze);
    }

    private AnalyzeModel createModel(Analyze analyze) {
        AnalyzeModel analyzeModel = new AnalyzeModel();
        analyzeModel.setId(analyze.getId());
        analyzeModel.setPatient(patientFacade.getPatientByUsername(analyze.getUsername()));
        analyzeModel.setReceivingDate(analyze.getReceivingDate());
        analyzeModel.setType(analyze.getType());
        analyzeModel.setContent(analyze.getContent());
        return analyzeModel;
    }
}
