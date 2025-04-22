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
import userdtb.userElectionpage1;

/**
 *
 * @author INDIA
 */
public class electionPage1Authenticator {
    public void isShow(userElectionpage1 user1){
        String election_name = user1.getElection_name();
        try
          {
              Statement st = DBConnecter.getStatement();          
              String query = "SELECT * FROM  election1";
              System.out.println("Query ="+query);
              ResultSet rs =st.executeQuery(query);
              if(rs.next())
                      {
                  user1.setElection_name(election_name);
          }
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
     }
}
