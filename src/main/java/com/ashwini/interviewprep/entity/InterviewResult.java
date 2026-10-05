package com.ashwini.interviewprep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InterviewResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private int score;
    private String feedback;

    // Default Constructor
    public InterviewResult() {
    }

    // Parameterized Constructor
    public InterviewResult(String email, int score, String feedback) {
        this.email = email;
        this.score = score;
        this.feedback = feedback;
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for Score
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Getter and Setter for Feedback
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "InterviewResult{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}