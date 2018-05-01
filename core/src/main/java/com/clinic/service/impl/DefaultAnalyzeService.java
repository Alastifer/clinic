package com.clinic.service.impl;

import com.clinic.dao.AnalyzeDAO;
import com.clinic.model.Analyze;
import com.clinic.service.AnalyzeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultAnalyzeService implements AnalyzeService {
    @Resource
    private AnalyzeDAO analyzeDAO;

    @Override
    public List<Analyze> getAnalyzes(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException();
        }

        return analyzeDAO.getAnalyzes(username);
    }

    @Override
    public Analyze getAnalyze(Long id, String username) throws IllegalArgumentException {
        if (id == null || username == null) {
            throw new IllegalArgumentException();
        }

        Optional<Analyze> analyze = analyzeDAO.getAnalyze(id, username);
        if (analyze.isPresent()) {
            return analyze.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
