package com.nishant.newsportal.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public String globalExceptionHandler(Model model, Exception ex){

        model.addAttribute("errorMsg", ex.getMessage());

        return "error.html";


    }

}
