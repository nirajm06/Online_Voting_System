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
import admindtb.adminaddCandidate;
import adminmodel.addCandidateAuthenticator;
import java.io.InputStream;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "addCandidateChecker", urlPatterns = {"/addCandidateChecker"})
public class addCandidateChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("adminMain.jsp");
}
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        
    System.out.println("In do post methord of Add image servlet.");
        
        String election_name = request.getParameter("election_name");
        System.out.println(election_name);
        String name = request.getParameter("name");
        System.out.println(name);
        String party_name = request.getParameter("party_name");
        System.out.println(party_name);
        String phoneNo = request.getParameter("phoneNo");
        System.out.println(phoneNo);
        String address = request.getParameter("address");
        System.out.println(address);
        System.out.println(election_name);
         adminaddCandidate user2 = new adminaddCandidate();
         
         user2.setName(name);
         user2.setAddress(address);
         user2.setPhoneNo(phoneNo);
         user2.setParty_name(party_name);
         user2.setElection_name(election_name);
         
         addCandidateAuthenticator rauthenticator = new addCandidateAuthenticator();
         boolean registration = rauthenticator.isAddCandidate(user2);
         
    if(registration){
        HttpSession session=request.getSession(true);
        session.setAttribute("election_name",election_name);
        session.setAttribute("name",name);
        response.sendRedirect("Add_CandidateImage.jsp");
    }
    else
    {
        response.sendRedirect("adminMain.jsp");
    }
       }  
}
