<%-- 
    Document   : Mainlogout
    Created on : 1 Jan, 2024, 5:05:50 AM
    Author     : INDIA
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="db.DBConnecter"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String email_id = request.getParameter("email_id");
        Cookie cookies[] = request.getCookies();
        for (int idx = 0; idx < cookies.length; idx++) 
        {       
               email_id = cookies[idx].getValue();
               System.out.println(cookies[idx].getName()+" = "+cookies[idx].getValue());
        }
         Date d1 = new Date();
         Date d2;
         System.out.println(email_id);
         System.out.println(d1);
         int i=0;
         try
          {
              
              Statement st = DBConnecter.getStatement();
                String query = "UPDATE clockofadmin SET logout_time ='"+d1+"' WHERE email_id='"+email_id+"'";
               i=st.executeUpdate(query);
               System.out.println(query);
          }
          
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
          
         if(i>0)
            {
                System.out.print("uploaded image");
                response.sendRedirect("userMain.jsp");
            }
         else{
            System.out.print("Failed to upload image");
            response.sendRedirect("MainHome.jsp");
     }
        %>
    </body>
</html>
