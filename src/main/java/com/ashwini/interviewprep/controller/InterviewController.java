package com.ashwini.interviewprep.controller;

import com.ashwini.interviewprep.entity.InterviewQuestion;
import com.ashwini.interviewprep.entity.InterviewResult;
import com.ashwini.interviewprep.repository.InterviewQuestionRepository;
import com.ashwini.interviewprep.repository.InterviewResultRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class InterviewController {

    @Autowired
    private InterviewResultRepository interviewResultRepository;

    @Autowired
    private InterviewQuestionRepository questionRepository;


    // Start Mock Interview
    @GetMapping("/startInterview")
    public String startInterview(
            Model model,
            HttpSession session) {

        String email =
                (String) session.getAttribute("email");

        // User not logged in
        if (email == null) {
            return "login";
        }

        // Fetch questions from database
        List<InterviewQuestion> dbQuestions =
                questionRepository.findByEmail(email);

        List<String> questions = new ArrayList<>();

        for (InterviewQuestion q : dbQuestions) {
            questions.add(q.getQuestion());
        }

        model.addAttribute("questions", questions);

        return "interview";
    }


    // Submit Interview
    @PostMapping("/submitInterview")
    public String submitInterview(
            @RequestParam int totalQuestions,
            @RequestParam Map<String, String> answers,
            Model model,
            HttpSession session) {

        int score = 0;

        // Calculate score
        for (String key : answers.keySet()) {

            if (key.startsWith("answer")) {

                String answer = answers.get(key);

                // Simple scoring logic
                if (answer != null &&
                        answer.trim().length() > 20) {

                    score += (100 / totalQuestions);
                }
            }
        }

        // Maximum score should not exceed 100
        if (score > 100) {
            score = 100;
        }

        // Feedback generation
        String feedback;

        if (score >= 80) {
            feedback =
                    "Excellent Performance! You are interview ready.";
        }
        else if (score >= 60) {
            feedback =
                    "Good Performance. Practice a few more technical concepts.";
        }
        else {
            feedback =
                    "Need More Practice. Focus on fundamentals and revise concepts.";
        }

        // Get logged-in user email
        String email =
                (String) session.getAttribute("email");

        if (email == null) {
            email = "guest@gmail.com";
        }

        // Save result in database
        InterviewResult result = new InterviewResult();

        result.setEmail(email);
        result.setScore(score);
        result.setFeedback(feedback);

        interviewResultRepository.save(result);

        // Send data to result page
        model.addAttribute("score", score);
        model.addAttribute("feedback", feedback);

        return "result";
    }
}