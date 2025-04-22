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
import userdtb.userElectionpage2;
import usermodel.electionPage2Authenticator;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "electionpage2Checker", urlPatterns = {"/electionpage2Checker"})
public class electionpage2Checker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
                  String name = request.getParameter("name");
                  String party_name = request.getParameter("party_name");
                  HttpSession session=request.getSession(true);
                  String election_name = (String) session.getAttribute("Election_name");
                  String vote = request.getParameter("vote");
                  String email_id = request.getParameter("email_id");
                  
                  Cookie cookies[] = request.getCookies();
                  for (int idx1 = 0; idx1 < cookies.length; idx1++){       
                  email_id = cookies[idx1].getValue();
                  System.out.println(cookies[idx1].getName()+" = "+cookies[idx1].getValue());
                  }
                  
                  userElectionpage2 user1 = new userElectionpage2();
                 
                  user1.setName(name);
                  user1.setParty_name(party_name);
                  user1.setElection_name(election_name);
                  user1.setVote(vote);
                  user1.setEmail_id(email_id);
                  
                  electionPage2Authenticator rauthenticator = new electionPage2Authenticator();
                  boolean show = rauthenticator.isShow(user1);
                  
                  if(show){
                  session.setAttribute("party_name",party_name);
                  session.setAttribute("vote",vote);
                  response.sendRedirect("ElectionPage2Voted.jsp");
                  }
                  else
                  {
                      response.sendRedirect("userMain.jsp");
                  }
}

}
