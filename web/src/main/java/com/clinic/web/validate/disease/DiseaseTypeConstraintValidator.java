package com.clinic.web.validate.disease;

import com.clinic.service.DiseaseService;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

public class DiseaseTypeConstraintValidator implements ConstraintValidator<DiseaseType, String> {
    @Resource
    private DiseaseService diseaseService;

    @Override
    public void initialize(DiseaseType constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> availableTypes = diseaseService.getAllDiseaseTypes();
        long count = availableTypes.stream()
                .map(String::toUpperCase)
                .filter(s -> s.equals(value.toUpperCase()))
                .count();
        return count == 1;
    }
}
