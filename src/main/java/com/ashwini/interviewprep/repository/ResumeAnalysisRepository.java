package com.ashwini.interviewprep.repository;

import com.ashwini.interviewprep.entity.ResumeAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeAnalysisRepository
        extends JpaRepository<ResumeAnalysis, Long> {

    ResumeAnalysis findTopByEmailOrderByIdDesc(String email);
}