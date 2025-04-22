/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import admindtb.adminView;
import admindtb.adminViewUpdate;
import admindtb.adminViewUserReject;
import db.DBConnecter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INDIA
 */
public class viewVotersAuthenticator {
    public boolean isViewVoters(adminViewUpdate user1){
        String email_id = user1.getEmail_id();
          int i=0;
         try
          {
              Statement st = DBConnecter.getStatement();
            String query = "UPDATE status1 SET status1='Accept' WHERE email_Id='"+email_id+"'";
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
    public boolean isViewVoters(adminViewUserReject user2){
      String email_id = user2.getEmail_id();
      int i=0,j=0;
      try {
          Statement st = DBConnecter.getStatement();
          String query1 = "UPDATE status1 SET status1='Rejected' WHERE email_Id='"+email_id+"'";
          i=st.executeUpdate(query1);
            
            
          String query="DELETE FROM voters1 where email_Id ='"+email_id+"'";
          System.out.println("Query=" +query);
          j =st.executeUpdate(query);
      }
      catch(SQLException ex){
          System.out.print(ex);
      }
      if(i>0 && j>0)
            {
                System.out.println("Data Rejected");
                System.out.println("data Deleted");
                return true;
            }
        System.out.println("not Deleted");  
        return false;
    }
    public void isViewVoters(adminView user){
        String user_id = user.getUser_id();
        String name = user.getName();
        String mailid = user.getMailid();
        String dob = user.getDob();
        String address= user.getAddress();
        String gender = user.getGender();
        String phoneNo=user.getPhoneNo();
        String status = user.getStatus();
        
         try
          {
              Statement st = DBConnecter.getStatement();          
              String query = "SELECT * FROM voters1";
              System.out.println("Query ="+query);
              ResultSet rs =st.executeQuery(query);
              if(rs.next())
                      {
                          user.setUser_id(user_id);
         user.setName(name);
         user.setMailid(mailid);
         user.setDob(dob);
         user.setAddress(address);
         user.setGender(gender);
         user.setPhoneNo(phoneNo);
         user.setStatus(status);
          }
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
    }
}