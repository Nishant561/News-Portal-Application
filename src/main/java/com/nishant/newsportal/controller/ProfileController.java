package com.nishant.newsportal.controller;

import com.nishant.newsportal.model.User;
import com.nishant.newsportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String displayProfilePage(Authentication auth, Model model){

        User authenticatedUser = userRepository.findByEmail(auth.getName());

        model.addAttribute("user", authenticatedUser);

        return "profile";
    }
}
