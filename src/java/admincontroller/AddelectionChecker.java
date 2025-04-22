/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import admindtb.adminaddelection;
import adminmodel.AddElectionAuthenticator;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddelectionChecker", urlPatterns = {"/AddelectionChecker"})
public class AddelectionChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("adminMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
         String ename = request.getParameter("ename");
         Cookie election_name = new Cookie("ename",ename);
         response.addCookie(election_name);
         String Edate = request.getParameter("Edate");
         
         adminaddelection user = new adminaddelection();
         
         user.setEname(ename);
         user.setEdate(Edate);
         
         AddElectionAuthenticator authenticator = new AddElectionAuthenticator();
         boolean login = authenticator.isAddElection(user);
    if(login){
        HttpSession session=request.getSession(true);
        session.setAttribute("ename",ename);
        response.sendRedirect("AdminHome.jsp");
    }
    else
    {
        response.sendRedirect("adminMain.jsp");
    }
}
}
