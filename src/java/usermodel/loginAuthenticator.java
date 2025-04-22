/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodel;

import db.DBConnecter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import userdtb.LoginTime;
import userdtb.userLogin;

/**
 *
 * @author INDIA
 */
@WebServlet(name = "userAuthenticator", urlPatterns = {"/userAuthenticator"})
public class loginAuthenticator extends HttpServlet {
  public boolean isLogin(userLogin user,String status){
        String mailid =user.getMailid();
        String password = user.getPassword();
        status = user.getStatus();
        String tablePassword=""; 
        String tableStatus="";
        
        try {
            Statement st = DBConnecter.getStatement();
            String query2="Select status1 from status1 where email_Id='"+mailid+"'";
            System.out.println("Query=" +query2);
            
            ResultSet rs=st.executeQuery(query2);
            
            if(rs.next()){
                tableStatus = rs.getString("status1");
            }
            
            String query="Select password from voters1 where email_Id='"+mailid+"'";
            System.out.println("Query=" +query);
            
            ResultSet rs1=st.executeQuery(query);
            
            if(rs1.next())
                tablePassword =  rs1.getString(1);
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        catch(NullPointerException ex){
            System.out.println(ex);
        }
       
         if(mailid!=null && password!=null && password.equals(tablePassword)){
         user.setStatus(tableStatus);
         System.out.println(tableStatus);
         return true;
         }
        return false;
  }
  public boolean isLoginTime(LoginTime user1){
        String mailid =user1.getMailid();
        
        try
          {
              Statement st = DBConnecter.getStatement();
                String query = "INSERT INTO status1(`email_Id`,`status1`) VALUES ('"+mailid+"','panding')";
              System.out.println("Query="+query);
              st.executeUpdate(query);
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
           catch(NullPointerException ex){
            System.out.println(ex);
           }
         System.out.println(mailid);
         if(mailid!=null)
            {
                System.out.print("uploaded image");
                return true;
            }
         else{
            System.out.print("Failed to upload image");
        return false;
         }
     }
}
