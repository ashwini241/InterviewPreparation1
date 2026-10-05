package com.ashwini.interviewprep.util;

import java.util.ArrayList;
import java.util.List;

public class SkillExtractor {

    public static List<String> extractSkills(String resumeText) {

        List<String> skills = new ArrayList<>();

        String[] skillKeywords = {
                "Java",
                "Spring",
                "Spring Boot",
                "Hibernate",
                "MySQL",
                "SQL",
                "Python",
                "HTML",
                "CSS",
                "JavaScript",
                "React",
                "Machine Learning",
                "Data Science",
                "Pandas",
                "NumPy",
                "Power BI",
                "C",
                "C++"
        };

        for (String skill : skillKeywords) {

            if (resumeText.toLowerCase()
                    .contains(skill.toLowerCase())) {

                skills.add(skill);
            }
        }

        return skills;
    }
}