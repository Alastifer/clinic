package com.clinic.service.impl;

import com.clinic.dao.DiseaseDAO;
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
    public List<Disease> getAllDiseasesByUsername(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException();
        }

        return diseaseDAO.getAllDiseasesByUsername(username);
    }

    @Override
    public Disease getDiseaseByIdAndUsername(Long id, String username) throws IllegalArgumentException {
        if (id == null || username == null) {
            throw new IllegalArgumentException();
        }

        Optional<Disease> disease = diseaseDAO.getDiseaseByIdAndUsername(id, username);
        if (disease.isPresent()) {
            return disease.get();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
