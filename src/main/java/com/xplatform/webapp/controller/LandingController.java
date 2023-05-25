package com.xplatform.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LandingController {
    @PostMapping("/crossplatform")
    public String handleCrossPlatform() {
        return "/landing/landing";
    }

    @PostMapping("/login")
    public String handleLoginBtn() {
        return "/landing/login";
    }

    @PostMapping("/about")
    public String handleAboutBtn() {
        return "/landing/about";
    }

    @PostMapping("/contact")
    public String handleContactBtn() {
        return "/landing/contact";
    }

}
