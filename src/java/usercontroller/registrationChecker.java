/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userdtb.userRegistration;
import usermodel.registrationAuthenticator;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "registrationChecker", urlPatterns = {"/registrationChecker"})
public class registrationChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    System.out.println("In do post methord of Add image servlet.");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob"); 
        String mailid = request.getParameter("email_id");
        String gender = request.getParameter("gender");
        String address= request.getParameter("address");
        String phoneNo=request.getParameter("phoneno");
       
         userRegistration user2 = new userRegistration();
         
         user2.setName(name);
         user2.setMailid(mailid);
         user2.setDob(dob);
         user2.setAddress(address);
         user2.setGender(gender);
         user2.setPhoneno(phoneNo);
         registrationAuthenticator rauthenticator = new registrationAuthenticator();
         boolean registration = rauthenticator.isRegistration(user2);
         
    if(registration){
        HttpSession session=request.getSession(true);
        session.setAttribute("email_id",mailid);
        response.sendRedirect("userMain.jsp");
    }
    else
    {
        response.sendRedirect("userMain.jsp");
    }
       }  
}
