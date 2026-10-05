package com.ashwini.interviewprep.entity;

import jakarta.persistence.*;

@Entity
public class ResumeAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String career;

    private Integer matchScore;

    @Column(length = 5000)
    private String skills;

    @Column(length = 5000)
    private String missingSkills;

    // Default Constructor
    public ResumeAnalysis() {
    }

    // Parameterized Constructor
    public ResumeAnalysis(String email,
                          String career,
                          Integer matchScore,
                          String skills,
                          String missingSkills) {
        this.email = email;
        this.career = career;
        this.matchScore = matchScore;
        this.skills = skills;
        this.missingSkills = missingSkills;
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

    // Getter and Setter for career
    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    // Getter and Setter for matchScore
    public Integer getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Integer matchScore) {
        this.matchScore = matchScore;
    }

    // Getter and Setter for skills
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    // Getter and Setter for missingSkills
    public String getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(String missingSkills) {
        this.missingSkills = missingSkills;
    }

    @Override
    public String toString() {
        return "ResumeAnalysis{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", career='" + career + '\'' +
                ", matchScore=" + matchScore +
                ", skills='" + skills + '\'' +
                ", missingSkills='" + missingSkills + '\'' +
                '}';
    }
}