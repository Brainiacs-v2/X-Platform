package com.xplatform.webapp.controller;

import com.xplatform.webapp.bean.AboutMe;
import com.xplatform.webapp.bean.User;
import com.xplatform.webapp.repository.PostRepository;
import com.xplatform.webapp.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProfileController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ProfileController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


}





