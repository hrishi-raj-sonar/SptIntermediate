/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.sql.SQLException;
import java.util.Scanner;
import com.syntech.sptintermediate.Reviewer;

class UsersModel<T extends AllUsers> {

//    static String role = getrole();
    T user;
    String userRole;

    UsersModel(T user) {
        this.user = user;
    }

//    public String printUserType(){
    public void printUserType() {
        String clsname = user.getClass().toString(); //returns sth like java.lang.String
        int mid = clsname.lastIndexOf('.') + 1;
        userRole = clsname.substring(mid);
        System.out.println(userRole);

//          return userRole;
    }

//    public static String getrole() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Who are you? : ");
//        String m = sc.next();
//        return m;
//    }
//    public void tasks(){
//        
//        if(userRole.equalsIgnoreCase("Developer")){
//            user.startStory();
//            user.finishStory();
//            user.deliverStory();
//        }
//        else if(userRole.equalsIgnoreCase("Reviewer")){
//            user.reviewStory();
//        }else{
//            System.out.println("Wrong choice!!!");
//        }
}
