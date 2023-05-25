package com.xplatform.webapp.service;

import com.xplatform.webapp.bean.AboutMe;
import com.xplatform.webapp.repository.AboutMeRepository;
import org.springframework.stereotype.Service;

@Service
public class AboutMeService {
    private final AboutMeRepository aboutMeRepository;

    public AboutMeService(AboutMeRepository postRepository) {
        this.aboutMeRepository = postRepository;
    }

    public AboutMe savePost(AboutMe aboutMe) {
        return aboutMeRepository.save(aboutMe);
    }
}

