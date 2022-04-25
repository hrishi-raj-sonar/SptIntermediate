/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author hrishi
 */
public class Reviewers extends AllUsers {

    public Reviewers(int id, String name, String email) {
        super(id, name, email);
    }
    
    private ArrayList<Reviewers> a = new ArrayList();

    @Override
    public void viewAllUsers() {
        System.out.println("Viewing all reviewers");
        for (Reviewers a1 : a) {
            System.out.println(a1.id + a1.name + a1.email);
        }
    }

    @Override
    public void setUserRole() {
        super.userRole = "Reviewer";
    }
    
    public void addUser(Reviewers r) {
        this.a.add(r);
    }
    
    public void removeUser(int id) {
        System.out.println("Removing developer with id "+ id);   
    }
    
    //Story methods using the story ods file test.ods
    
    public void reviewStory() {
        File file = new File("test.ods");
        StoryOdsReaderWriter objODSCreator = new StoryOdsReaderWriter();
        objODSCreator.reviewStory(file);
    }
}
