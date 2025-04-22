package usercontroller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "userSet_PasswordEmail", urlPatterns = {"/userSet_PasswordEmail"})
public class userSet_PasswordEmail extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userMain.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the email parameter
        String mailid = request.getParameter("email");

        if (mailid == null || mailid.isEmpty()) {
            response.getWriter().println("Email address is missing.");
            return;
        }

        // Generate a random OTP
        String otp = generateOTP(6); // 6-digit OTP

        // Setup properties for the email
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Define your Gmail username and app-specific password here
        final String username = "aniketplacement2025@gmail.com"; // replace with your email
        final String password = "xcry yodo bigf pvbm"; // replace with your App Password

        // Create a session with authentication
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username)); // sender's email
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailid));  // recipient's email from input
            msg.setSubject("Your OTP Code");
            msg.setText("Your OTP code is: " + otp);

            // Send the message
            Transport.send(msg);
            response.getWriter().println("OTP sent successfully!");

            // Store OTP in the session for later verification
            HttpSession sessionObj = request.getSession();
            sessionObj.setAttribute("otp", otp); // Store OTP in session for verification in setPassword.java
            System.out.println("OTP sent successfully: " + otp);

        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to send email: " + e.getMessage());
        }
    }

    // Method to generate a random OTP of given length
    private String generateOTP(int length) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // append a random digit from 0-9
        }
        return otp.toString();
    }
}
