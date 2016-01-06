/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpt.model;

/**
 *
 * @author nguyenvan
 */
public class User {
    private String user;

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    private String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
