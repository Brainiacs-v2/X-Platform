package com.xplatform.webapp.repository;

import com.xplatform.webapp.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User getById(long id);
    User findByUsername(String name);

    User findByEmail(String email);
}
