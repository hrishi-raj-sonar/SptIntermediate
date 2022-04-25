/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.util.ArrayList;

/**
 *
 * @author hrishi
 */
public class Developers extends AllUsers {


    public Developers(int id, String name, String email) {
        super(id, name, email);
    }
    

    @Override
    public void setUserRole() {
        super.userRole = "Developer";
    }

    private ArrayList<Developers> a = new ArrayList();
    
    @Override
    public void viewAllUsers() {
        System.out.println("Viewing all developers: ");
        for (Developers a1 : a) {
            System.out.println(a1.id + a1.name + a1.email);
        }
    }

    public void addUser(Developers d) {
        this.a.add(d);
    }

    public void removeUser(int id) {
        System.out.println("Removing developer with id "+ id);   
    }
}
