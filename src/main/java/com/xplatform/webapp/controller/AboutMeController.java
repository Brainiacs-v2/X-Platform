package com.xplatform.webapp.controller;

import com.xplatform.webapp.bean.AboutMe;
import com.xplatform.webapp.service.AboutMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/about")
public class AboutMeController {
    private final AboutMeService aboutMeService;

    @Autowired
    public AboutMeController(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping("/edit")
    public String showEditAboutMeForm(Model model) {
        AboutMe aboutMe = new AboutMe();
        model.addAttribute("aboutMe", aboutMe);
        return "edit_about_me";
    }

    @PostMapping("/edit")
    public String saveAboutMe(@ModelAttribute("aboutMe") AboutMe aboutMe) {
        AboutMe savedAboutMe = aboutMeService.savePost(aboutMe);
        // Redirect to the profile page or update the model with the new About Me data
        return "redirect:/profile";
    }
}

