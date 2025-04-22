/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import admindtb.adminAdminResult;
import db.DBConnecter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INDIA
 */
public class adminViewResultAuthenticator {
    public void isShow(adminAdminResult user1){
        String election_name = user1.getElection_name();
        String End_dateofelection = user1.getEnd_dateofelection();
        
        try
          {
              Statement st = DBConnecter.getStatement();          
              String query = "SELECT * FROM  election1";
              System.out.println("Query ="+query);
              ResultSet rs =st.executeQuery(query);
              if(rs.next())
                      {
                  user1.setElection_name(election_name);
                  user1.setEnd_dateofelection(End_dateofelection);
          }
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
     }
}
