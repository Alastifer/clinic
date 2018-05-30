package com.clinic.service.impl;

import com.clinic.dao.AnalyzeDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Analyze;
import com.clinic.service.AnalyzeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultAnalyzeService implements AnalyzeService {
    @Resource
    private AnalyzeDAO analyzeDAO;

    @Override
    public List<Analyze> getAllAnalyzesByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username must not be null");
        }

        return analyzeDAO.getAllAnalyzesByUsername(username);
    }

    @Override
    public Analyze getAnalyzeByIdAndUsername(Long id, String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username must not be null");
        } else if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }

        try {
            return analyzeDAO.getAnalyzeByIdAndUsername(id, username);
        } catch (AmbiguousIdentifierException | UnknownIdentifierException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    public List<String> getAllAnalyzeTypes() {
        return analyzeDAO.getAllAnalyzeTypes();
    }

    @Override
    public void save(Analyze analyze) {
        if (analyze == null) {
            throw new IllegalArgumentException("Analyze must not be null");
        }

        analyzeDAO.save(analyze);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }

        analyzeDAO.delete(id);
    }
}
