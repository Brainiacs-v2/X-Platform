package com.xplatform.webapp.repository;

import com.xplatform.webapp.bean.Post;
import com.xplatform.webapp.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findAllByUser(User user);
    // Additional methods can be defined here if needed
}

