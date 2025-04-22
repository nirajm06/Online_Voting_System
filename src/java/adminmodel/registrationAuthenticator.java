/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import db.DBConnecter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import userdtb.userRegistration;

/**
 *
 * @author INDIA
 */
public class registrationAuthenticator {
     public boolean isRegistration(userRegistration user2){
        String name = user2.getName();
        String mailid = user2.getMailid();
        String dob = user2.getDob();
        String address= user2.getAddress();
        String gender = user2.getGender();
        String phoneNo=user2.getPhoneno();
        
         try
          {
              Connection con = DBConnecter.getConnection();
              Statement stmt;
                 String query = "INSERT INTO admin1(`name`,`email_Id`,`dob`,`address`,`gender`,`phoneNo`) VALUES ('"+name+"','"+mailid+"','"+dob+"','"+address+"','"+gender+"','"+phoneNo+"')";
              stmt = con.prepareStatement(query);
               System.out.println("Query="+query);
            int i= stmt.executeUpdate(query);
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
         catch(NullPointerException ex){
             System.out.println(ex);
         }
         
         if(name!=null && mailid!=null && dob!=null && address!=null && phoneNo!=null && gender!=null && mailid.endsWith("@gmail.com"))
            {
                System.out.print("uploaded image");
                return true;
            }
            System.out.print("Failed to upload image");
        return false;
        
    }

   
}
