package com.ashwini.interviewprep.util;

import java.util.ArrayList;
import java.util.List;

public class SkillGapAnalyzer {

    public static List<String> findMissingSkills(List<String> skills) {

        String[] recommendedSkills = {
                "Java",
                "Spring Boot",
                "MySQL",
                "REST API",
                "Git",
                "HTML",
                "CSS"
        };

        List<String> missingSkills = new ArrayList<>();

        for (String skill : recommendedSkills) {

            if (!skills.contains(skill)) {
                missingSkills.add(skill);
            }
        }

        return missingSkills;
    }
}