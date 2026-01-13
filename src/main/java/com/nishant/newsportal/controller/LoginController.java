package com.nishant.newsportal.controller;


import com.nishant.newsportal.model.User;
import com.nishant.newsportal.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/login")
    public String displayLoginPage(@RequestParam(name = "register" , required = false) String register, @RequestParam(name = "errors", required = false) String error, Model model){
        model.addAttribute("user", new User());

        return "login.html";
    }








}
