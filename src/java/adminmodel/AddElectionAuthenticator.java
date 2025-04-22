/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import admindtb.adminaddelection;
import db.DBConnecter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INDIA
 */
public class AddElectionAuthenticator {
 public   boolean isAddElection(adminaddelection user){
        String ename =user.getEname();
        String Edate = user.getEdate();
        
        try {
            Connection con = DBConnecter.getConnection();
            String query="INSERT INTO election1(`election_name`,`end_dateofelection`) VALUES ('"+ename+"','"+Edate+"')";
            Statement st = con.prepareStatement(query);
             System.out.println("Query="+query);
            st.executeUpdate(query);
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }
     if(ename!=null && Edate!=null){
        return true;
    }
     return false;
}
}
