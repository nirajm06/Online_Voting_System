/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercontroller;


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
import usermodel.loginAuthenticator;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "loginChecker", urlPatterns = {"/loginChecker"})
public class loginChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
         String mailid = request.getParameter("email_id");
         HttpSession session=request.getSession(true);
         session.setAttribute("email_id",mailid);
         Cookie email_id = new Cookie("email_id",mailid);
         response.addCookie(email_id);
         String password = request.getParameter("password");
         String status = request.getParameter("status");
         String user_id;
         String panding = "panding";
         Date d1 = new Date();
         System.out.println(d1);
         
         LoginTime user1 = new LoginTime();
         userLogin user = new userLogin();
         
         user.setMailid(mailid);
         user1.setMailid(mailid);
         user.setPassword(password);
         
         loginAuthenticator authenticator = new loginAuthenticator();
         boolean loginTime = authenticator.isLoginTime(user1);
         System.out.println(loginTime);
         boolean login = authenticator.isLogin(user,status);
         System.out.println("Status is"+status);
         try {
         if(user.getStatus().equalsIgnoreCase(panding)){
         PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User_Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("alert('Yor Registration ID will go to the verification Wait for Approval!');");
            out.println("</script>");
            out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
           }
         else {
         if(login){
        session.setAttribute("password",password);
        session.setAttribute("status",status);
        response.sendRedirect("UserHome.jsp");
        }
        else if(loginTime){
        session.setAttribute("d1", d1);
        }
        else
        {
        response.sendRedirect("userMain.jsp");
        }
      }
    }
      catch(NullPointerException e){
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