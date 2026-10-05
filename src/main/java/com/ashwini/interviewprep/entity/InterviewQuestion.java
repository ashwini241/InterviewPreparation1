package com.ashwini.interviewprep.entity;

import jakarta.persistence.*;

@Entity
public class InterviewQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(length = 1000)
    private String question;

    // Default Constructor
    public InterviewQuestion() {
    }

    // Parameterized Constructor
    public InterviewQuestion(String email, String question) {
        this.email = email;
        this.question = question;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "InterviewQuestion{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}