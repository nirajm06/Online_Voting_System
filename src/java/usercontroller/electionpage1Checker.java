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
import userdtb.userElectionpage1;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "electionpage1Checker", urlPatterns = {"/electionpage1Checker"})
public class electionpage1Checker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
                  String election_name = request.getParameter("election_name");
                  Cookie cookies[] = request.getCookies();
                  for (int idx = 0; idx < cookies.length; idx++) 
                 {       
                election_name = cookies[idx].getValue();
                System.out.println(cookies[idx].getName()+" = "+cookies[idx].getValue());
                 }
                  userElectionpage1 user1 = new userElectionpage1();
                     response.sendRedirect("ElectionPage2.jsp");
  }
}
