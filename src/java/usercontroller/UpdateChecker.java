/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercontroller;

import usermodel.UpdateAuthenticator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userdtb.userUpdate;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "UpdateChecker", urlPatterns = {"/UpdateChecker"})
public class UpdateChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    System.out.println("In do post methord of Add image servlet.");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob"); 
        String email_id =request.getParameter("email_id");
        Cookie cookies[] = request.getCookies();
        for (int idx = 0; idx < cookies.length; idx++){       
                email_id = cookies[idx].getValue();
                System.out.println(cookies[idx].getName()+" = "+cookies[idx].getValue());
        }
        String gender = request.getParameter("gender");
        String address= request.getParameter("address");
        String phoneNo=request.getParameter("phoneno");
       
         userUpdate user = new userUpdate();
         
         user.setName(name);
         user.setEmail_id(email_id);
         user.setDob(dob);
         user.setAddress(address);
         user.setGender(gender);
         user.setPhoneno(phoneNo);
         
         UpdateAuthenticator rauthenticator = new UpdateAuthenticator();
         boolean registration = rauthenticator.isUserUpdate(user);
         
    if(registration){
        HttpSession session=request.getSession(true);
        session.setAttribute("email_id",email_id);
        response.sendRedirect("userMain.jsp");
    }
    else
    {
        response.sendRedirect("userMain.jsp");
    }
   }  
}
