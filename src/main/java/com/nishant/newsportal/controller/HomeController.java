package com.nishant.newsportal.controller;


import com.nishant.newsportal.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {




    @GetMapping("/home")
    public String displayHomePage(Authentication auth , Model model){
        String email = auth.getName();
        List<String> roles = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        model.addAttribute("email", email);
        model.addAttribute("role", roles);


        return "index.html";
    }
}
