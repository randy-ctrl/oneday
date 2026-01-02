package com.waw3ru.oneday.model;

import jakarta.persistence.*;
@Entity
@Table(name = "tasks")


public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private boolean completed = false;
    
    public Task() {}

    // Getters and setters


    public Task(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
