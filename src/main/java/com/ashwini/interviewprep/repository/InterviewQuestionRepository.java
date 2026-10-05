package com.ashwini.interviewprep.repository;

import com.ashwini.interviewprep.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InterviewQuestionRepository
        extends JpaRepository<InterviewQuestion, Long> {

    List<InterviewQuestion> findByEmail(String email);

    @Transactional
    @Modifying
    void deleteByEmail(String email);
}