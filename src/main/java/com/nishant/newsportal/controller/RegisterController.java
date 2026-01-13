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
public class RegisterController {


    private  UserServices userServices;

    @Autowired
    public RegisterController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/register")
    public String displayRegisterPage(@RequestParam(name = "error", required = false) String error, Model model){
        model.addAttribute("user", new User());
        return "register.html";
    }

    @PostMapping("/saveuser")
    public String saveUser(@Valid @ModelAttribute("user") User user, Errors error){
        if(error.hasErrors()){
            return "register.html";
        }
        boolean isSaved = userServices.createNewUser(user);

        if(isSaved){
            return "redirect:/login?register=true";
        }

        return "redirect:/register?error=true";
    }

}
