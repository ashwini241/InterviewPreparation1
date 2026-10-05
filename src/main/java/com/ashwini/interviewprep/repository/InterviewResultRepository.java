package com.ashwini.interviewprep.repository;

import com.ashwini.interviewprep.entity.InterviewResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterviewResultRepository
        extends JpaRepository<InterviewResult, Long> {

    // User Specific Statistics

    @Query("SELECT MAX(i.score) FROM InterviewResult i WHERE i.email=?1")
    Integer getHighestScore(String email);

    @Query("SELECT AVG(i.score) FROM InterviewResult i WHERE i.email=?1")
    Double getAverageScore(String email);

    @Query("SELECT COUNT(i) FROM InterviewResult i WHERE i.email=?1")
    Long getTotalInterviews(String email);

    List<InterviewResult> findTop5ByEmailOrderByIdDesc(String email);

    @Query("SELECT i.score FROM InterviewResult i WHERE i.email=?1 ORDER BY i.id")
    List<Integer> getAllScores(String email);
}