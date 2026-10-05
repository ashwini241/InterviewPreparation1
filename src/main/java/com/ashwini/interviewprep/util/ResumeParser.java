package com.ashwini.interviewprep.util;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class ResumeParser {

    public static String extractText(String filePath) {

        try {

            PDDocument document =
                    Loader.loadPDF(new File(filePath));

            PDFTextStripper stripper =
                    new PDFTextStripper();

            String text =
                    stripper.getText(document);


            document.close();

            return text;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}