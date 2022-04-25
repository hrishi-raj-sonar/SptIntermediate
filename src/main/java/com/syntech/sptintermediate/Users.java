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
public class Users {
    
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
    
    public static Developer createDeveloper(int id, String name, String email) {
        Developer d = new Developer();
        
        UsersModel<Developer> u = new UsersModel(d);
        u.printUserType();
        return d;
    }
    
    public static Reviewer createReviewer(int id, String name, String email){
        Reviewer r = new Reviewer();
        UsersModel<Reviewer> u = new UsersModel(r);
        return r;
    }
    
//   
     
    public static void main(String[] args) {
         Developer d = createDeveloper(1, "Ram", "ram@gmail.com");
//         createReviewer(2, "Zebra", "zebra@zabri.com");
        d.startStory();
        d.deliverStory();
        
        Reviewer r = createReviewer(2, "Gaurab", "gaurab@gmail.com");
        
        r.reviewStory();
    }
}
