package com.clinic.web.facade.impl;

import com.clinic.model.Analyze;
import com.clinic.service.AnalyzeService;
import com.clinic.web.facade.AnalyzeFacade;
import com.clinic.web.facade.PatientFacade;
import com.clinic.web.model.AnalyzeModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public void save(AnalyzeModel analyzeModel) {
        Analyze analyze = new Analyze();
        analyze.setId(analyzeModel.getId());
        analyze.setUsername(analyzeModel.getPatient().getUsername());
        analyze.setReceivingDate(convertToTimestamp(analyzeModel.getReceivingDate() + ":00"));
        analyze.setType(analyzeModel.getType());
        analyze.setContent(analyzeModel.getContent());
        analyzeService.save(analyze);
    }

    @Override
    public void delete(Long id) {
        analyzeService.delete(id);
    }

    private AnalyzeModel createModel(Analyze analyze) {
        AnalyzeModel analyzeModel = new AnalyzeModel();
        analyzeModel.setId(analyze.getId());
        analyzeModel.setPatient(patientFacade.getPatientByUsername(analyze.getUsername()));
        analyzeModel.setReceivingDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(analyze.getReceivingDate()));
        analyzeModel.setType(analyze.getType());
        analyzeModel.setContent(analyze.getContent());
        return analyzeModel;
    }

    private Timestamp convertToTimestamp(String dateString) {
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }

        dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return Timestamp.valueOf(dateString);
    }
}
