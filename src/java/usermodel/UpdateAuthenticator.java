/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodel;

import db.DBConnecter;
import java.sql.SQLException;
import java.sql.Statement;
import userdtb.userUpdate;

/**
 *
 * @author INDIA
 */
public class UpdateAuthenticator {
    public boolean isUserUpdate(userUpdate user){
        String name = user.getName();
        String email_id = user.getEmail_id();
        String dob = user.getDob();
        String address= user.getAddress();
        String gender = user.getGender();
        String phoneNo=user.getPhoneno();
        int i=0;
         try
          {
              Statement st = DBConnecter.getStatement();
            
            String query = "UPDATE voters1 SET name='"+name+"' or dob='"+dob+"' or address='"+address+"' or gender='"+gender+"' or phoneNo='"+phoneNo+"' WHERE email_Id='"+email_id+"'"; 
            
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
