/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import admindtb.adminResult;
import db.DBConnecter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INDIA
 */
public class finalResultAuthenticator {
 public void isShow(adminResult user1){
         String name = user1.getName();
        String party_name = user1.getParty_name();
        String address= user1.getAddress();
        String vote = user1.getVote();
        String ename =user1.getEname();
        
        try
          {
              Statement st = DBConnecter.getStatement();          
              String query = "SELECT * FROM  candidate1";
              System.out.println("Query ="+query);
              ResultSet rs =st.executeQuery(query);
              if(rs.next())
                      {
         user1.setName(name);
         user1.setParty_name(party_name);
         user1.setAddress(address);
         user1.setVote(vote);
         user1.setEname(ename);
          }
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
     }   
}
