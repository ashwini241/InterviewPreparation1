package com.ashwini.interviewprep.controller;

import com.ashwini.interviewprep.entity.InterviewResult;
import com.ashwini.interviewprep.repository.InterviewResultRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private InterviewResultRepository repository;

    @GetMapping("/performance")
    public String performance(
            Model model,
            HttpSession session) {

        // Get logged-in user email from session
        String email =
                (String) session.getAttribute("email");

        if (email == null) {
            return "login";
        }

        // User-specific statistics
        Long totalInterviews =
                repository.getTotalInterviews(email);

        Integer highestScore =
                repository.getHighestScore(email);

        Double averageScore =
                repository.getAverageScore(email);

        List<InterviewResult> recentResults =
                repository.findTop5ByEmailOrderByIdDesc(email);

        List<Integer> scores =
                repository.getAllScores(email);

        // Send data to performance.html
        model.addAttribute(
                "totalInterviews",
                totalInterviews == null ? 0 : totalInterviews);

        model.addAttribute(
                "highestScore",
                highestScore == null ? 0 : highestScore);

        model.addAttribute(
                "averageScore",
                averageScore == null ? 0 :
                        Math.round(averageScore));

        model.addAttribute(
                "recentResults",
                recentResults);

        model.addAttribute(
                "scores",
                scores);

        model.addAttribute(
                "userEmail",
                email);

        return "performance";
    }
}