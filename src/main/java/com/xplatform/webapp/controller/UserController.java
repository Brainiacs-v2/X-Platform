package com.xplatform.webapp.controller;

import com.xplatform.webapp.bean.*;

import com.xplatform.webapp.repository.UserRepository;

import com.xplatform.webapp.repository.UserRepository;
import jakarta.persistence.Entity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;



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



    @GetMapping("/")
    public String loginPage() {
        return "login";
    }
//
//    @GetMapping("/")
//    public String loginPage(@ModelAttribute User user) {
//        return "/login";
//    }
//

    }
