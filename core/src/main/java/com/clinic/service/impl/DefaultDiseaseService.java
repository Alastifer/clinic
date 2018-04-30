package com.clinic.service.impl;

import com.clinic.dao.DiseaseDAO;
import com.clinic.model.Disease;
import com.clinic.service.DiseaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultDiseaseService implements DiseaseService {
    @Resource
    private DiseaseDAO diseaseDAO;

    @Override
    public List<Disease> getDiseases(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException();
        }

        return diseaseDAO.getAllDiseasesByUsername(username);
    }
}
