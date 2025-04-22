/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import db.DBConnecter;
import java.sql.SQLException;
import java.sql.Statement;
import userdtb.userSetPassword;

/**
 *
 * @author INDIA
 */
public class SetPasswordAuthenticator {
     public boolean isReset(userSetPassword user){
        String mailid =user.getMailid();
        String cp = user.getCp();
        String password = user.getPassword();
        
        int tablePassword= 0;
        try {
            Statement st = DBConnecter.getStatement();
            String query="Update admin1 SET password='"+password+"' where email_Id='"+mailid+"'";
            System.out.println("Query=" +query);
            
            tablePassword =st.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
         if(tablePassword >0)
            {
                System.out.println("data updated");
                return true;
            }
        System.out.println("not updated");  
        return false;
    }
}
