/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercontroller;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author ratho
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
    maxFileSize = 1024 * 1024 * 50,      // 50 MB
    maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet(name = "AadhaarExtractorServlet", urlPatterns = {"/AadhaarExtractorServlet"})
public class AadhaarExtractorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Part for uploaded file
        System.setProperty("TESSDATA_PREFIX", "C:/Program Files/Tesseract-OCR/");
        
        Part filePart = request.getPart("aadhaarImage");

        // Directory where the uploaded file will be saved temporarily
        String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdir();
        }

        // Save uploaded file
        String fileName = getFileName(filePart);
        File uploadedFile = new File(uploadDir + File.separator + fileName);
        FileUtils.copyInputStreamToFile(filePart.getInputStream(), uploadedFile);
        
        
        // Extract text from image using Tesseract
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata"); // Path to your Tesseract installation

        String extractedText = null;
        try {
            extractedText = tesseract.doOCR(uploadedFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }

        // Extract Aadhaar number and Mobile number using regex
        String aadhaarNumber = extractAadhaarNumber(extractedText);
        String mobileNumber = extractMobileNumber(extractedText);

        // Send Aadhaar number and Mobile number as response
        if (aadhaarNumber != null || mobileNumber != null) {
            response.getWriter().write("Extracted Aadhaar Number: " + aadhaarNumber + "<br>");
            response.getWriter().write("Extracted Mobile Number: " + mobileNumber + "<br>");
        } else {
            response.getWriter().write("No valid Aadhaar or Mobile number found.");
        }

        // Clean up uploaded file
        uploadedFile.delete();
    }

    // Method to extract Aadhaar number using a regex pattern
    private String extractAadhaarNumber(String text) {
        String aadhaarRegex = "\\b\\d{4}\\s\\d{4}\\s\\d{4}\\b";
        Pattern pattern = Pattern.compile(aadhaarRegex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    // Method to extract Mobile number using a regex pattern
    private String extractMobileNumber(String text) {
        String mobileRegex = "\\b[6-9]\\d{9}\\b"; // Matches Indian mobile numbers starting with 6-9 and having 10 digits
        Pattern pattern = Pattern.compile(mobileRegex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    // Helper method to get the file name of the uploaded file
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }
}