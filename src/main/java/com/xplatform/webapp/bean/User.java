package com.xplatform.webapp.bean;

import com.xplatform.webapp.util.Password;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100, unique = true)
    private String username;

    @Column (nullable = false, length = 100, unique = true)
    private String email;

    @Column (nullable = false, length = 100)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Forum> forums = new ArrayList<>();

    @OneToMany()
    private List<AboutMe> aboutMe;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_channels",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private final Set<Channel> channels = new HashSet<>();
    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(User copy){
        id = copy.id;

        username = copy.username;
        email = copy.email;
        password = copy.password;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }
}

