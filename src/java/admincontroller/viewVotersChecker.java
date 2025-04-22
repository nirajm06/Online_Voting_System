/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import admindtb.adminView;
import admindtb.adminViewUpdate;
import admindtb.adminViewUserReject;
import adminmodel.viewVotersAuthenticator;
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
@WebServlet(name = "viewVotersChecker", urlPatterns = {"/viewVotersChecker"})
public class viewVotersChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    System.out.println("In do post methord of Add image servlet.");
        /*String user_id = request.getParameter("user_id");
        Cookie userid = new Cookie("user_id",user_id);
        response.addCookie(userid);*/
        String name = request.getParameter("name");
        String dob = request.getParameter("dob"); 
        String mailid = request.getParameter("mailid");
        String gender = request.getParameter("gender");
        String address= request.getParameter("address");
        String phoneNo=request.getParameter("phoneNo");
        String status = request.getParameter("status");
        String radio1 = request.getParameter("radio1");
        System.out.println("radio1 :"+radio1);
        String Execution = null;
        Cookie cookies[] = request.getCookies();
        for(int idx = 0; idx < cookies.length; idx++){       
                Execution  = cookies[idx].getValue();
                System.out.println(cookies[idx].getName()+" = "+cookies[idx].getValue());
        }
        adminViewUpdate user1 = new adminViewUpdate();
        adminViewUserReject user2 = new adminViewUserReject();
        adminView user = new adminView();
        if(radio1.equals("Accept"))
        user1.setEmail_id(Execution);
        else 
        user2.setEmail_id(Execution);
        
         viewVotersAuthenticator rauthenticator = new viewVotersAuthenticator();
         boolean registration = rauthenticator.isViewVoters(user1);
         boolean rejection =  rauthenticator.isViewVoters(user2);
    if(registration){
        HttpSession session=request.getSession(true);
        session.setAttribute("mailid",mailid);
        response.sendRedirect("View_Voters.jsp");
    }
    else if(rejection){
        HttpSession session=request.getSession(true);
        session.setAttribute("mailid",mailid);
        response.sendRedirect("View_Voters.jsp");
    }
    else
    {
        response.sendRedirect("adminMain.jsp");
    }
  }
}


