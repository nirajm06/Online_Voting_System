/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminmodel;

import admindtb.adminaddCandidate;
import db.DBConnecter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author INDIA
 */
public class addCandidateAuthenticator {
    public boolean isAddCandidate(adminaddCandidate user1){
        String election_name = user1.getElection_name();
        System.out.println(election_name);
        String name = user1.getName();
        String party_name = user1.getParty_name();
        System.out.println(party_name);
        String address= user1.getAddress();
        System.out.println(address);
        String phoneNo=user1.getPhoneNo();
        System.out.println(phoneNo);
        Connection con=null;
        
         try
          {
              con = DBConnecter.getConnection();
              PreparedStatement stmt;
                 String query = "INSERT INTO candidate1(`election_name`,`name`,`party_name`,`phoneNo`,`address`,`vote`) VALUES ('"+election_name+"','"+name+"','"+party_name+"','"+phoneNo+"','"+address+"','0')";
              stmt = con.prepareStatement(query);
               System.out.println("Query="+query);
               int i = stmt.executeUpdate();
               if (i > 0)
                System.out.print("File uploaded and saved into database");
          }
          catch(SQLException ex)
          {
              System.out.println(ex);
          }   
         if(name!=null && party_name!=null && address!=null && phoneNo!=null && election_name!=null)
            {
                System.out.print("uploaded image");
                return true;
            }
            System.out.print("Failed to upload image");
        return false;
        }
    }