/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INDIA
 */
public class DBConnecter {
    static Connection con=null;
    static Statement st =null;
    
    static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingsystem","root","root");
        System.out.println("Connector");
        st = con.createStatement();
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        } 
    }
    public static Statement getStatement()
    {
        return st;
    }
    public static Connection getConnection(){
        return con;
    }
}

