package com.xplatform.webapp.bean;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Other role-related fields

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    // Getters and setters
}

