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
@RequestMapping("/profile")
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userRepository.save(user);
        // Retrieve the current user's profile from the repository
        // and pass it to the view for pre-populating the form
        // replace "getCurrentUser()" with actual logic
        AboutMe aboutMe = aboutMeRepository.findByUser(getCurrentUser());
        model.addAttribute("aboutMe", aboutMe);
        return "profile-create";
    }

    @PostMapping("/edit")
    public String handleEditProfileForm(@ModelAttribute("aboutMe") AboutMe aboutMe) {
        // Save the updated profile to the repository
        aboutMeRepository.save(aboutMe);
        // Redirect to the profile page or a success page
        return "redirect:/profile";
    }


    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}






