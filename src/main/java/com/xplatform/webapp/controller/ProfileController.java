package com.xplatform.webapp.controller;

import com.xplatform.webapp.repository.AboutMeRepository;
import com.xplatform.webapp.repository.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController {

    private final UserRepository userRepository;
    private final AboutMeRepository postRepository;

    public ProfileController(UserRepository userRepository, AboutMeRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


}





