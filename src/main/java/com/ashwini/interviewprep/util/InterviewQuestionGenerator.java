package com.ashwini.interviewprep.util;

import java.util.*;

public class InterviewQuestionGenerator {

    public static List<String> generateQuestions(List<String> skills) {

        List<String> questions = new ArrayList<>();

        for(String skill : skills) {

            switch(skill.toLowerCase()) {

                case "java":
                    questions.add("Explain OOP concepts in Java.");
                    questions.add("What is inheritance in Java?");
                    questions.add("Difference between Abstract class and Interface?");
                    break;

                case "mysql":
                    questions.add("What is a Primary Key?");
                    questions.add("Explain SQL Joins.");
                    questions.add("Difference between DELETE and TRUNCATE.");
                    break;

                case "html":
                    questions.add("What is semantic HTML?");
                    questions.add("Difference between div and span.");
                    break;

                case "css":
                    questions.add("What is Flexbox?");
                    questions.add("Difference between Grid and Flexbox.");
                    break;

                case "spring":
                    questions.add("What is Dependency Injection?");
                    questions.add("Explain Spring Boot architecture.");
                    break;

                case "python":
                    questions.add("What are Python decorators?");
                    questions.add("Difference between List and Tuple.");
                    break;

                case "machine learning":
                    questions.add("Explain supervised learning.");
                    questions.add("What is overfitting?");
                    break;

                case "power bi":
                    questions.add("What is DAX in Power BI?");
                    questions.add("What is a dashboard?");
                    break;
            }
        }

        // General HR Questions
        questions.add("Tell me about yourself.");
        questions.add("Why should we hire you?");
        questions.add("What are your strengths and weaknesses?");

        return questions;
    }
}