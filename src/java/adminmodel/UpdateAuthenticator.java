/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import db.DBConnecter;
import java.sql.SQLException;
import java.sql.Statement;
import admindtb.adminUpdate;

/**
 *
 * @author INDIA
 */
public class UpdateAuthenticator {
    public boolean isAdminUpdate(adminUpdate user2){
        String name = user2.getName();
        String email_id = user2.getEmail_id();
        String dob = user2.getDob();
        String address= user2.getAddress();
        String gender = user2.getGender();
        String phoneNo=user2.getPhoneno();
         int i=0;
         try
          {
              Statement st = DBConnecter.getStatement();
            
            String query = "UPDATE admin1 SET name='"+name+"' or dob='"+dob+"' or address='"+address+"' or gender='"+gender+"' or phoneNo='"+phoneNo+"' WHERE email_Id='"+email_id+"'"; 
            
            i=st.executeUpdate(query);
              System.out.println(query);
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
         
         if(i>0)
            {
                System.out.println("data updated");
                return true;
            }
        System.out.println("not updated");  
        return false;
        
    }
   
}
