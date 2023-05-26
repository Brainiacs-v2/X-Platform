package com.xplatform.webapp.controller;

import com.xplatform.webapp.bean.AboutMe;
import com.xplatform.webapp.bean.User;
import com.xplatform.webapp.repository.AboutMeRepository;
import com.xplatform.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    private final UserRepository userRepository;
    private final AboutMeRepository aboutMeRepository;

    @Autowired
    public ProfileController(UserRepository userRepository, AboutMeRepository aboutMeRepository) {
        this.userRepository = userRepository;
        this.aboutMeRepository = aboutMeRepository;
    }

    @GetMapping("/edit-profile")
    public String showEditProfileForm(Model model) {
        return "profile-create";
    }

    @PostMapping("/edit-profile")
    public String handleEditProfileForm(@ModelAttribute("aboutMe") AboutMe aboutMe) {
        return "redirect:/profile-create";
    }


    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}






