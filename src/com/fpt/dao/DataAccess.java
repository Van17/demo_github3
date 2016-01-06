/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpt.dao;

import com.fpt.db.DBUtils;
import com.fpt.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenvan
 */
public class DataAccess {
    public List<Product> getAll(){ 
     List<Product>  ls = new LinkedList<>();
        try {
            String sql = "select*from tbl_product";
            Statement stm=DBUtils.getConnection().createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
               Product p = new Product(rs.getInt(1), rs.getString(2),rs.getFloat(3)); 
               ls.add(p);
            }
        } catch (Exception e) {
        }
         
    return ls ;
    
    
}
     public List<Product> getProductById(int id){ 
     List<Product>  ls = new LinkedList<>();
        try {
            String sql = "select top(1) from tbl_product where id=?";
            Statement stm=DBUtils.getConnection().createStatement();
            ResultSet rs=stm.executeQuery(sql);
           if(rs.next()){
               Product p = new Product(rs.getInt(1), rs.getString(2),rs.getFloat(3)); 
               ls.add(p);
            }
        } catch (Exception e) {
        }
         
    return ls ;
    
    
}
    public void addNew(Product p){
        String sql = "insert into tbl_product values(?,?)";
        try {
            PreparedStatement pre = DBUtils.getConnection().prepareStatement(sql);
            pre.setString(1,p.getName());
            pre.setFloat(2, p.getPrice());
            pre.executeUpdate();
        } catch (Exception e) {
           
        }
    }
    public boolean checkLogin(String user, String pass) {


//    String sql = "select count(*) as count from Account "
//                + " where UserName = ? and Password = ?";
//    
        String sql = "select * from tb_user "
                + " where username = ? and pass = ?";

        try {
            PreparedStatement preSta = DBUtils.getConnection().prepareStatement(sql);
            preSta.setString(1, user);
            preSta.setString(2, pass);

            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {     
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    
    
//    Demo
    
    public List<Product> getAll1() throws SQLException{
    List<Product> ls=new LinkedList<>();
        try {
         ResultSet rs=  DBUtils.getPreparedStatement("select * from tbl_product").executeQuery();
         while(rs.next()){
         Product p=new Product(rs.getInt(1), rs.getString(2),rs.getFloat(3));
         
         ls.add(p);
         
         }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
    return ls;
    }
    public void addNew1(Product p){
        String sql="insert into tbl_product values(?,?)";
        try {
            PreparedStatement pre=DBUtils.getPreparedStatement(sql);
            pre.setString(1,p.getName());
            pre.setFloat(2, p.getPrice());
            pre.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
