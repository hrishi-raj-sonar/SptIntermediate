/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;
//import com.syntech.sptintermediate.MySqlConnection;

import java.sql.SQLException;

/**
 *
 * @author hrishi
 */
public class Developer extends UsersMethods implements IDeveloper{

//    public Developer(Object) {
//        super(user);
//    }

//    private int id;
//    private String name;
//    private String email;
//    
//    Developer(int id, String name, String email){
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
    
    public void startStory(){
        System.out.println("Starting story...");
    }
    
    public void finishStory(){
        System.out.println("Finishing story...");
    }
    
    public void deliverStory(){
        System.out.println("Delivering story...");
    }
}
