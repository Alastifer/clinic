package com.clinic.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument() {
        return "404";
    }
}
