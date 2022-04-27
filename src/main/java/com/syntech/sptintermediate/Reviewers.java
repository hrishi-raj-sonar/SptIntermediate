/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hrishi
 */
public class Reviewers extends AllUsers {

    public Reviewers(int id, String name, String email) {
        super(id, name, email);
    }
    
    private ArrayList<Reviewers> a = new ArrayList();

    public void viewAllUsers(){
        super.viewAllUsers(a);
    };

    @Override
    public void setUserRole() {
        super.userRole = "Reviewer";
    }
    
    public void addUser(Reviewers r) {
        this.a.add(r);
    }
    
    public void removeUser(int id) {
        System.out.println("Removing developer with id "+ id);   
        Reviewers r = null;
        
        for (Reviewers a1 : a){
            if(a1.id == id){
               r = a1; 
            }
        }
        
        System.out.println("Removing reviewer with id " + id);
        a.remove(r);
    }
    
    
//    Reviewer's list options
    
    public void listOptions() {

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new reviewer to list | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Reviewers reviewerObj = createReviewersObject();
                    addUser(reviewerObj);
                    break;
                case 2:
                    System.out.println("What developer to remove? : ");
                    int removeUserId = sc.nextInt();
                    removeUser(removeUserId);
                    break;
                case 3:
                    viewAllUsers();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println("Work again with list? Yes/No");
            String againChoice = sc.next();

            if (againChoice.equalsIgnoreCase("Yes")) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
    }
    

//    Create Reviewers objects
    
    private static Reviewers createReviewersObject() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter reviewer id: ");
        int id = sc.nextInt();

        System.out.println("Enter reviewer name: ");
        String name = sc.next();

        System.out.println("Enter reviewer email: ");
        String email = sc.next();

        Reviewers reviewerObject = new Reviewers(id, name, email);
        reviewerObject.setUserRole();

        return reviewerObject;
    }
    
    
//    Reviewer's JDBC Options
    @Override
    public void jdbcOptions() throws SQLException {
        MySqlConnection m = new MySqlConnection();
        m.establishConnection();

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new reviewer to database | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    m.add();
                    break;
                case 2:
                    m.delete();
                    break;
                case 3:
                    m.read();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println("Work again with jdbc? Yes/No");
            String againChoice = sc.next();

            if (againChoice.equalsIgnoreCase("Yes")) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
    }
    
    
//    Reviewer's ods options
    @Override
    public void odsOptions() {
        File file = new File("reviewers.ods");
            UsersOdsReaderWriter obj = new UsersOdsReaderWriter();
            obj.removeOdsRow(file);
            
            Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new developer to database | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.addToODS(file);
                    continue;
                case 2:
                    obj.removeOdsRow(file);
                    break;
                case 3:
                    obj.readODS(file);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println("Work again with ods? Yes/No");
            String againChoice = sc.next();

            if (againChoice.equalsIgnoreCase("Yes")) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
    }
    
    
//    Reviewer's story options
    @Override
    public void storyOptions(){
        
        Scanner sc = new Scanner(System.in);
        
        reviewStory();
    }
    
    //Story methods using the story ods file test.ods
    
    public void reviewStory() {
        File file = new File("test.ods");
        StoryOdsReaderWriter objODSCreator = new StoryOdsReaderWriter();
        objODSCreator.reviewStory(file);
    }

}
