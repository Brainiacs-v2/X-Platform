package com.xplatform.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LandingController {

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    //POST MAPPING
    @PostMapping("/crossplatform")
    public String crossPlatformBtn(){
        return "index";
    }
    @PostMapping("/about")
    public String aboutBtn(){
        return "about";
    }
    @PostMapping("/contact")
    public String contactBtn(){
        return "contact";
    }
    @PostMapping("/register-page")
    public String registerBtn(){
        return "register";
    }

}


