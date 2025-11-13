package com.onlineexam.online_exam_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration; // in minutes
    private int passMarks;
    private String description; // added description field

    // Constructors
    public Exam() {}

    public Exam(String title, int duration, int passMarks, String description) {
        this.title = title;
        this.duration = duration;
        this.passMarks = passMarks;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getPassMarks() { return passMarks; }
    public void setPassMarks(int passMarks) { this.passMarks = passMarks; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
