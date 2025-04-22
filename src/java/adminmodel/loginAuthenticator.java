/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import db.DBConnecter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import userdtb.userLogin;

/**
 *
 * @author INDIA
 */
public class loginAuthenticator {
    public   boolean isLogin(userLogin user){
        String mailid =user.getMailid();
        String password = user.getPassword();
        
        String tablePassword=""; 
        
        try {
            Statement st = DBConnecter.getStatement();
            String query="Select Password from admin1 where email_Id='"+mailid+"'";
            System.out.println("Query=" +query);
            
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
                tablePassword =rs.getString(1);
        }
        catch(SQLException e){
            System.out.println(e);
        }
     if(mailid!=null && password!=null && password.equals(tablePassword)){
        return true;
    }
     return false;
 }
}
