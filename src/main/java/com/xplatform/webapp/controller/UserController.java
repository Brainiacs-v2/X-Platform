package com.xplatform.webapp.controller;

import com.xplatform.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
import com.xplatform.webapp.bean.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {
    @Autowired
    private UserRepository userDao;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

//afsdfsdfadf

    @GetMapping("/login")
    public String loginPage() {
        return "landing/login";
    }

    @GetMapping("/profile")
    public String profilePages(@ModelAttribute User user) {
        User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "profile";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        return "landing/register";
    }

    @PostMapping("/register")
    public String reghistrationPagepost(@RequestParam("username") String username, @RequestParam("password") String password,
    @RequestParam("email") String email                                    ) {
        userDao.save(new User(username, email, password));
        return "profile";
    }

    }
