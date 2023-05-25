package com.xplatform.webapp.controller;

import com.xplatform.webapp.bean.AboutMe;
import com.xplatform.webapp.repository.AboutMeRepository;
import com.xplatform.webapp.service.AboutMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/about")
public class AboutMeController {
    private final AboutMeService aboutMeService;
    private final AboutMeRepository aboutMeRepository;

    @Autowired
    public AboutMeController(AboutMeService aboutMeService,
                             AboutMeRepository aboutMeRepository) {
        this.aboutMeService = aboutMeService;
        this.aboutMeRepository = aboutMeRepository;
    }
    @GetMapping("/profile/create")
    public String createProfile(Model model) {
        AboutMe aboutMe = new AboutMe(); // Replace this with your actual AboutMe object instantiation
        model.addAttribute("aboutMe", aboutMe);
        return "profile-create";
    }
    @GetMapping("/edit")
    public String showEditAboutMeForm(Model model) {
        AboutMe aboutMe = new AboutMe();
        model.addAttribute("aboutMe", aboutMe);
        return "profile-create";
    }

    @PostMapping("/edit")
    public String saveAboutMe(@ModelAttribute("aboutMe") AboutMe aboutMe) {
        AboutMe savePost = aboutMeService.savePost(aboutMe);
        aboutMeRepository.save(savePost);
        // Redirect to the profile page or update the model with the new About Me data
        return "redirect:/profile";
    }
}

