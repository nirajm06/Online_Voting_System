/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userdtb.userSetPassword;
import adminmodel.SetPasswordAuthenticator;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "AsetPassword", urlPatterns = {"/AsetPassword"})
public class AsetPassword extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    String mailid = request.getParameter("email");
    String cp = request.getParameter("cp");
    String password = request.getParameter("password");
         
         userSetPassword user = new userSetPassword();
         
         user.setMailid(mailid);
         user.setPassword(password);
         
         SetPasswordAuthenticator authenticator = new SetPasswordAuthenticator();
         boolean reset = authenticator.isReset(user);
    if(reset){
        HttpSession session=request.getSession(true);
        session.setAttribute("email",mailid);
        response.sendRedirect("adminMain.jsp");
    }
    else
    {
        response.sendRedirect("userMain.jsp");
    }
}
}
