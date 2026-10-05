package com.ashwini.interviewprep.util;

import java.util.ArrayList;
import java.util.List;

public class LearningRecommendation {

    public static List<String> getRecommendations(
            List<String> missingSkills) {

        List<String> recommendations =
                new ArrayList<>();

        for(String skill : missingSkills) {

            switch(skill) {

                case "Spring Boot":
                    recommendations.add(
                            "Learn Spring Boot and build REST APIs");
                    break;

                case "REST API":
                    recommendations.add(
                            "Practice REST API development using Spring Boot");
                    break;

                case "Git":
                    recommendations.add(
                            "Learn Git and GitHub for version control");
                    break;

                case "Python":
                    recommendations.add(
                            "Learn Python fundamentals and problem solving");
                    break;

                case "Machine Learning":
                    recommendations.add(
                            "Study ML algorithms and Scikit-Learn");
                    break;

                case "Power BI":
                    recommendations.add(
                            "Create interactive dashboards in Power BI");
                    break;

                default:
                    recommendations.add(
                            "Improve knowledge of " + skill);
            }
        }

        return recommendations;
    }
}