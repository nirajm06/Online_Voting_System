/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermodel;

import db.DBConnecter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import userdtb.userElectionpage2;

/**
 *
 * @author INDIA
 */
public class electionPage2Authenticator {
    public boolean isShow(userElectionpage2 user1){
        String name = user1.getName();
        String party_name = user1.getParty_name();
        String election_name = user1.getElection_name();
        String vote = user1.getVote();
        String email_id = user1.getEmail_id();
        System.out.println(email_id);
        int i=0,j=0,k=1,l;
        l = Integer.parseInt(vote);
        
         try
          {
               Connection con = DBConnecter.getConnection();
               PreparedStatement stmt = null;
               String query2 = "INSERT INTO votes(`email_Id`,`election_name`,`vote`) VALUES ('"+email_id+"','"+election_name+"','"+party_name+"')";
               stmt = con.prepareStatement(query2);
               j=stmt.executeUpdate();
               System.out.println(query2);
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
          try {
               Statement st = DBConnecter.getStatement();            
               String query = "UPDATE candidate1 SET vote='"+(l+k)+"' WHERE party_name='"+party_name+"'";
               i=st.executeUpdate(query);
               System.out.println(query);
          }
          catch(SQLException ex){
              System.out.println(ex);
          }
         
         if(i>0 || j>0)
            {
                System.out.println("Voted");
                return true;
            }
        System.out.println("not Voted");  
        return false;
        
    }
}
