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
public class UsersMethods {
    
    public void mySqlConnect() throws SQLException {
        MySqlConnection q = new MySqlConnection() {
        };
        q.establishConnection();
        q.read();
    }

    public void msSqlConnect() throws SQLException {
        MySqlConnection q = new MySqlConnection();
        q.establishConnection();
        q.read();
    }
    
    public static void createDeveloper(int id, String name, String email) {
        Developer d = new Developer();
        
        Users<IDeveloper> u = new Users(d);
        u.printUserType();
        u.tasks();
    }
    
//    public static Reviewer createReviewer (int id, String name, String email){
//        Reviewer rev = new Reviewer();
//        
//        Users<Developer> u = new Users(rev);
//        u.printUserType();
//        u.tasks();
//        return rev;
//    }
     
    public static void main(String[] args) {
         createDeveloper(1, "Ram", "ram@gmail.com");
//         createReviewer(2, "Zebra", "zebra@zabri.com");
    }
}
