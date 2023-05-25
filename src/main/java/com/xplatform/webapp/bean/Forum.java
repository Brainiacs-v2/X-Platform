package com.xplatform.webapp.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "forums")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    public Forum(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Forum(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Forum(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Forum(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Forum() {

    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
// Other forum-related fields

// Getters and setters


