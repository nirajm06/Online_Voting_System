/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admincontroller;

import admindtb.adminResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "viewResultChecker", urlPatterns = {"/viewResultChecker"})
public class viewResultChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("userMain.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
                  String name = request.getParameter("name");
                  String party_name = request.getParameter("party_name");
                  String address = request.getParameter("address");
                  String vote = request.getParameter("vote");
                  String ename = request.getParameter("ename");
                  
                  adminResult user1 = new adminResult();
                 
                  HttpSession session=request.getSession(true);
                  session.setAttribute("party_name",party_name);
                  session.setAttribute("name",name);
                  session.setAttribute("vote",vote);
                  session.setAttribute("address",address);
                  session.setAttribute("ename",ename);
}
}