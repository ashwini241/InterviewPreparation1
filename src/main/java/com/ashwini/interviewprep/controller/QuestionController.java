package com.ashwini.interviewprep.controller;

import com.ashwini.interviewprep.entity.InterviewQuestion;
import com.ashwini.interviewprep.repository.InterviewQuestionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private InterviewQuestionRepository repository;

    @GetMapping("/questions")
    public String questions(
            Model model,
            HttpSession session) {

        String email =
                (String) session.getAttribute("email");

        System.out.println("Session Email = " + email);

        if(email == null) {
            return "login";
        }

        List<InterviewQuestion> dbQuestions =
                repository.findByEmail(email);

        System.out.println("Questions Found = "
                + dbQuestions.size());

        for(InterviewQuestion q : dbQuestions) {
            System.out.println(q.getQuestion());
        }

        List<String> questions = new ArrayList<>();

        for(InterviewQuestion q : dbQuestions) {
            questions.add(q.getQuestion());
        }

        model.addAttribute("questions", questions);

        return "questions";
    }
}