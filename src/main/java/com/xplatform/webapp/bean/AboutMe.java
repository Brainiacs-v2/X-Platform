package com.xplatform.webapp.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "about_me")
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;
    @OneToOne
    private User user;

    public AboutMe(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public AboutMe(String title, String body) {
        this.title = title;
        this.body = body;
    }
    public AboutMe(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public AboutMe(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }
    public AboutMe() {

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
