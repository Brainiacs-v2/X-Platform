package com.xplatform.webapp.repository;

import com.xplatform.webapp.bean.AboutMe;
import com.xplatform.webapp.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe, Long> {
    AboutMe findAllByUser(User user);

    AboutMe findByUser(User currentUser);
    // Additional methods can be defined here if needed
}

