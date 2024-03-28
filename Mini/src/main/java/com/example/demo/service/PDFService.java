package com.example.demo.service;

import jakarta.mail.MessagingException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PDFService
{
    @Autowired
    TimetableService timetableService;
    @Autowired
    EmailService emailService;
    public void createPDF() throws IOException, MessagingException {
        try (PDDocument document = new PDDocument()) {
            List<String> timetable = timetableService.createTimetable();

            int yPosition = 700; // Initial Y position for text
            int currentPageNumber = 1;
            PDPage currentPage = null;
            PDPageContentStream contentStream = null;

            for (String entry : timetable) {
                if (contentStream == null || yPosition < 70) {
                    // Create a new page if there is no current page or if the Y position is too low
                    if (currentPage != null) {
                        contentStream.close();
                    }
                    currentPage = new PDPage();
                    document.addPage(currentPage);
                    contentStream = new PDPageContentStream(document, currentPage);
                    contentStream.setFont(PDType1Font.HELVETICA, 23);
                    yPosition = 700;
                }

                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText(entry);
                contentStream.endText();
                yPosition -= 20; // Move the Y position upwards for the next line
            }

            if (contentStream != null) {
                contentStream.close();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            byte[] generateTimetable = byteArrayOutputStream.toByteArray();
            emailService.sendMail("gheewalasaurav44@gmail.com",generateTimetable);
        }
    }

}
