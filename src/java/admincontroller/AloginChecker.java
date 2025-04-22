/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import adminmodel.loginAuthenticator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userdtb.LoginTime;
import userdtb.userLogin;


/**
 *
 * @author INDIA
 */
@WebServlet(name = "AloginChecker", urlPatterns = {"/AloginChecker"})
public class AloginChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("adminMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
         String mailid = request.getParameter("email_id");
         String password = request.getParameter("password");
         Date d1 = new Date();
         System.out.println(d1);
         
         userLogin user = new userLogin();
         
         user.setMailid(mailid);
         user.setPassword(password);
         
         loginAuthenticator authenticator = new loginAuthenticator();
         boolean login = authenticator.isLogin(user);
         
    if(login){
        HttpSession session=request.getSession(true);
        session.setAttribute("email",mailid);
        response.sendRedirect("AdminHome.jsp");
    }
    else
    {
         PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Wrong Email and Password</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("alert('Your Entered Email Id and Passowrd Should be wrong');");
            out.println("</script>");
            out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
    }
}
}
