package com.clinic.service.impl;

import com.clinic.dao.DiseaseDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Disease;
import com.clinic.service.DiseaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultDiseaseService implements DiseaseService {
    @Resource
    private DiseaseDAO diseaseDAO;

    @Override
    public List<Disease> getAllDiseasesByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username must not be null");
        }

        return diseaseDAO.getAllDiseasesByUsername(username);
    }

    @Override
    public Disease getDiseaseByIdAndUsername(Long id, String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username must not be null");
        } else if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }

        try {
            return diseaseDAO.getDiseaseByIdAndUsername(id, username);
        } catch (AmbiguousIdentifierException | UnknownIdentifierException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    public List<String> getAllDiseaseTypes() {
        return diseaseDAO.getAllDiseaseTypes();
    }

    @Override
    public void save(Disease disease) {
        if (disease == null) {
            throw new IllegalArgumentException("Disease must not be null");
        }

        diseaseDAO.save(disease);
    }

    @Override
    public void remove(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }

        diseaseDAO.remove(id);
    }
}
