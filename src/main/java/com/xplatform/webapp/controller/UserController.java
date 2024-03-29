package com.xplatform.webapp.controller;

import com.xplatform.webapp.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.xplatform.webapp.bean.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/crossplatform")
    public String landingPage() {
        return "index";
    }

    @GetMapping("/profile")
    public String profilePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    //redirect to loginPage after register
    @PostMapping("/register")
    public String registrationPagePost(@RequestParam("username") String username, @RequestParam("password") String password,
                                       @RequestParam("email") String email) {
        userDao.save(new User(username, email, password));
        return "redirect:/login";
    }
    //redirect to profile after login
    @PostMapping("/login-to-profile")
    public String loginToProfilePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/profile";
        }
        return "login";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/4xx";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/5xx";
            }
        }
        return "error";
    }
}




