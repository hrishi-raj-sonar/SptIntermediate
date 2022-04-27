/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hrishi
 */
public abstract class AllUsers <T extends AllUsers>{

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
    
    public void viewAllUsers(List<T> list) {
        System.out.println("Viewing all developers: ");
        for (T a1 : list) {
            System.out.println(a1.id + a1.name + a1.email);
        }
    }
    
    public abstract void jdbcOptions() throws SQLException;
    
    public abstract void odsOptions();
    
    public abstract void listOptions();
    
    public abstract void storyOptions();
    
   
  
}
