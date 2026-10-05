package com.ashwini.interviewprep.util;

import java.util.List;

public class CareerRecommendation {

    public static String recommend(List<String> skills) {

        if (skills.contains("Java")
                && skills.contains("Spring Boot")
                && skills.contains("MySQL")) {

            return "Full Stack Java Developer";
        }

        else if (skills.contains("Python")
                && skills.contains("Machine Learning")
                && skills.contains("Data Science")) {

            return "Data Scientist";
        }

        else if (skills.contains("Python")
                && skills.contains("Pandas")
                && skills.contains("NumPy")) {

            return "Data Analyst";
        }

        else if (skills.contains("HTML")
                && skills.contains("CSS")
                && skills.contains("JavaScript")) {

            return "Frontend Developer";
        }

        else if (skills.contains("Java")
                && skills.contains("MySQL")) {

            return "Java Developer";
        }

        else if (skills.contains("MySQL")
                && skills.contains("SQL")) {

            return "Database Developer";
        }

        else if (skills.contains("Power BI")
                && skills.contains("SQL")) {

            return "Business Intelligence Analyst";
        }

        else if (skills.contains("Python")
                && skills.contains("SQL")) {

            return "Data Analyst";
        }

        return "Software Developer";
    }
}