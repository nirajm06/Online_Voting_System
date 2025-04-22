package usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userdtb.userSetPassword;
import usermodel.SetPasswordAuthenticator;

@WebServlet(name = "setPassword", urlPatterns = {"/setPassword"})
public class setPassword extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userMain.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters
        String mailid = request.getParameter("email");
        String otpInput = request.getParameter("otp"); // OTP entered by user
        String password = request.getParameter("password");

        // Get the generated OTP from the session
        HttpSession session = request.getSession();
        String generatedOtp = (String) session.getAttribute("otp");

        // Verify the OTP
        if (generatedOtp != null && generatedOtp.equals(otpInput)) {
            // OTP is correct, proceed to reset password
            userSetPassword user = new userSetPassword();
            user.setMailid(mailid);
            user.setPassword(password);

            SetPasswordAuthenticator authenticator = new SetPasswordAuthenticator();
            boolean reset = authenticator.isReset(user);

            if (reset) {
                session.setAttribute("email", mailid); // save email in session if needed
                response.sendRedirect("userMain.jsp");
            } else {
                response.sendRedirect("error.jsp"); // Redirect to error page if reset failed
            }
        } else {
            // OTP is incorrect
            response.getWriter().println("Incorrect OTP. Please try again.");
        }
    }
}
