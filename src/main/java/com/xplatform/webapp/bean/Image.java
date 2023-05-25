package com.xplatform.webapp.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String path;
    // Add more image attributes as needed

    public Image() {
        // Default constructor
    }

    // Getters and setters for the image attributes

    public long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Long.parseLong(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
