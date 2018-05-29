package com.clinic.web.validate;

import com.clinic.service.AnalyzeService;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class AnalyzeTypeConstraintValidator implements ConstraintValidator<AnalyzeType, String> {
    @Resource
    private AnalyzeService analyzeService;

    @Override
    public void initialize(AnalyzeType constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> availableTypes = analyzeService.getAllAnalyzeTypes();
        long count = availableTypes.stream()
                .map(String::toUpperCase)
                .filter(s -> s.equals(value.toUpperCase()))
                .count();
        return count == 1;
    }
}
