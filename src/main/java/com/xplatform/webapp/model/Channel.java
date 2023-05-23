package com.xplatform.webapp.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Other channel-related fields

    @ManyToMany(mappedBy = "channels")
    private Set<User> users = new HashSet<>();

    // Getters and setters
}

