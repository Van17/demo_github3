/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenvan
 */
public class DBUtils {
    private static Connection con =null;
    public static Connection getConnection( ){
     
  
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://VANNGUYEN\\SQLEXPRESS:49194;databaseName=demo_jsp";
            String user = "sa";
            String pass = "123456";
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return con;
    }
    
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        PreparedStatement pre=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=demo_jsp";
        String user="sa";
        String pass="123456";
        Connection con=DriverManager.getConnection(url, user, pass);
        pre=con.prepareStatement(sql);       
        return pre;
    }
    
    
    
    public static void main(String[] args) {
        try {
           // getPreparedStatement("select * from tbl_product");
            getConnection().prepareStatement("select * from user");
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
