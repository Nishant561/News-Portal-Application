package com.nishant.newsportal.controller;


import com.nishant.newsportal.model.User;
import com.nishant.newsportal.services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
    public String displayLoginPage(@RequestParam(name = "register" , required = false) String register, @RequestParam(name = "errors", required = false) String error, @RequestParam(name = "logout" , required = false) String logout, Model model){
        model.addAttribute("user", new User());



        if(error != null){
            model.addAttribute("errMsg", "Invalid Email or password");
        }


        return "login.html";
    }


    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest req, HttpServletResponse res){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null){
            new SecurityContextLogoutHandler().logout(req,res,auth);
        }

        return "redirect:/login?logout=true";
    }







}
