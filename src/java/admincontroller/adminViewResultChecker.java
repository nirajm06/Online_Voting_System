/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import admindtb.adminAdminResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "adminViewResultChecker", urlPatterns = {"/adminViewResultChecker"})
public class adminViewResultChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
                  String election_name = request.getParameter("election_name");
                  String End_dateofelection = request.getParameter("End_dateofelection");
                  
                  Cookie cookies[] = request.getCookies();
                  for (int idx = 0; idx < cookies.length; idx++) 
                 {       
                election_name = cookies[idx].getValue();
                System.out.println(cookies[idx].getName()+" = "+cookies[idx].getValue());
                 }
                  adminAdminResult user1 = new adminAdminResult();
                  response.sendRedirect("Final_Result.jsp");
                  HttpSession session=request.getSession(true);
                  session.setAttribute("election_name",election_name);
                  session.setAttribute("End_dateofelection",End_dateofelection);
}
}
