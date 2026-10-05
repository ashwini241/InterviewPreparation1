package com.ashwini.interviewprep.controller;

import com.ashwini.interviewprep.entity.InterviewQuestion;
import com.ashwini.interviewprep.repository.InterviewQuestionRepository;
import com.ashwini.interviewprep.util.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.File;
import java.util.List;

@Controller
public class ResumeController {
    @Autowired
    private InterviewQuestionRepository questionRepository;

    @GetMapping("/uploadResumePage")
    public String uploadResumePage() {
        return "uploadResume";
    }



    @PostMapping("/uploadResume")
    public String uploadResume(
            @RequestParam("resumeFile") MultipartFile file,
            Model model,
            HttpSession session) {


        try {

            String uploadDir =
                    "C:/Users/deore/IdeaProjects/InterviewPrep/uploads/";

            File directory = new File(uploadDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath =
                    uploadDir + file.getOriginalFilename();

            file.transferTo(new File(filePath));

            System.out.println("=================================");
            System.out.println("File Saved At: " + filePath);
            System.out.println("=================================");

            String text = ResumeParser.extractText(filePath);

            System.out.println("===== RESUME TEXT =====");
            System.out.println(text);

            List<String> skills =
                    SkillExtractor.extractSkills(text);
            List<String> missingSkills =
                    SkillGapAnalyzer.findMissingSkills(skills);
            String career =
                    CareerRecommendation.recommend(skills);

            List<String> recommendations =
                    LearningRecommendation.getRecommendations(
                            missingSkills);

            model.addAttribute(
                    "recommendations",
                    recommendations);

            int totalSkills = skills.size() + missingSkills.size();

            int matchScore = 0;

            if(totalSkills > 0) {
                matchScore = (skills.size() * 100) / totalSkills;
            }

            model.addAttribute("career", career);
            model.addAttribute("skills", skills);
            model.addAttribute("missingSkills", missingSkills);
            model.addAttribute("matchScore", matchScore);

            model.addAttribute("career", career);

            model.addAttribute("skills", skills);
            model.addAttribute("missingSkills", missingSkills);
            System.out.println("===== DETECTED SKILLS =====");

            for(String skill : skills) {
                System.out.println(skill);
            }

            List<String> questions =
                    InterviewQuestionGenerator.generateQuestions(skills);

            String email =
                    (String) session.getAttribute("email");

// Delete old questions of this user
            questionRepository.deleteByEmail(email);

// Save new questions
            for(String q : questions) {

                InterviewQuestion question =
                        new InterviewQuestion();

                question.setEmail(email);
                question.setQuestion(q);

                questionRepository.save(question);
            }

            model.addAttribute("questions", questions);

            return "resumeAnalysis";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";


    }


}
