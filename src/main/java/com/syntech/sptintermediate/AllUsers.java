/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

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
    
   
  
}
