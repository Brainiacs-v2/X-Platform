package com.xplatform.webapp.controller;

import com.xplatform.webapp.bean.Post;
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
    @GetMapping("/login")
    public String loginPage() {
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post posts = postRepository.findAllByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("posts", posts);
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String getIndividualPost(@PathVariable long id, Model model) {
        Optional<Post> currentPost = postRepository.findById(id);
        currentPost.ifPresent(post -> model.addAttribute("post", post));
        return "profile";
    }

    @GetMapping("/edit-profile")
    public String editProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "profile-create"; // Return the "profile-create" view instead of "edit-profile"
    }
    @PostMapping("/edit-profile")
    public String handleEditBtn() {
        return "/profile-create";
    }

    @PostMapping("/update-about-me")
    public String updateAboutMe(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/profile";
    }

    @PostMapping("/delete-post/{id}")
    public String deletePostById(@PathVariable long id) {
        postRepository.deleteById(id);
        return "redirect:/profile";
    }

    @PostMapping("/edit-post")
    public String editPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/profile";
    }
}





