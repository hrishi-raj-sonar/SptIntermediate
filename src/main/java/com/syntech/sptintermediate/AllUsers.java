/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.sql.SQLException;

/**
 *
 * @author hrishi
 */
public abstract class AllUsers {
    
    int id;
    String name;
    String email;
    String userRole;
    
    AllUsers(int id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public abstract void setUserRole();
    
    public abstract void viewAllUsers();
    
    public abstract void jdbcOptions() throws SQLException;
    
    public abstract void odsOptions();
    
    public abstract void listOptions();
    
    public abstract void storyOptions();
    
   
  
}
