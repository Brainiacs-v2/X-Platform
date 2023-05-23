package com.xplatform.webapp.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "forums")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Other forum-related fields

    // Getters and setters
}

