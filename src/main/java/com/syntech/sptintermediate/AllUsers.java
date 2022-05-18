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
    
    public String getAllUsers(List<T> list) {
        
//        getting T classname only
        String userTypeClass = ""+list.get(0).getClass();
        String userType =  userTypeClass.substring(userTypeClass.lastIndexOf(".")+1);
        
        System.out.println("Viewing all " + userType);
        
//        storing all users in a string
        String allUsers = "";
        for (T a1 : list) {
                allUsers = allUsers + a1.id + "  "+ a1.name + "  "+ a1.email + "\n";
        }
        
        return allUsers;
    }
    
    public void viewAllUsers(List<T> list){
        String allUsers = getAllUsers(list);
        System.out.println(allUsers);
    }
    
    public abstract void jdbcOptions() throws SQLException;
    
    public abstract void odsOptions();
    
    public abstract void listOptions();
    
    public abstract void storyOptions();
    
   
  
}
