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
public class Requestors extends AllUsers {

    public Requestors(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void setUserRole() {
        super.userRole = "Requestor";
    }
    
    private ArrayList<Requestors> a = new ArrayList();

    @Override
    public void viewAllUsers() {
        System.out.println("Viewing all requestors: ");
        for (Requestors a1 : a) {
            System.out.println(a1.id + a1.name + a1.email);
        }
    }
    
    public void addUser(Requestors r) {
        this.a.add(r);
    }
    
    public void removeUser(int id) {
        System.out.println("Removing requestor with id "+ id);   
    }
    
    
//    Story List Options
    @Override
    public void listOptions() {

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new requestor to list | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Requestors requestorObj = createRequestorsObject();
                    addUser(requestorObj);
                    break;
                case 2:
                    System.out.println("What  to remove? : ");
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
    
//    Create Requestors object
    
    private static Requestors createRequestorsObject() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter reviewer id: ");
        int id = sc.nextInt();

        System.out.println("Enter requestor name: ");
        String name = sc.next();

        System.out.println("Enter requestor email: ");
        String email = sc.next();

        Requestors requestorObject = new Requestors(id, name, email);
        requestorObject.setUserRole();

        return requestorObject;
    }
    
    
//    Requestor's JDBC Options
    @Override
    public void jdbcOptions() throws SQLException {
        MySqlConnection m = new MySqlConnection();
        m.establishConnection();

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new requestor to database | 2 to delete from | 3 to view from database: ");
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
    
    
//    Requestor's ods options
    @Override
    public void odsOptions() {
        File file = new File("requestors.ods");
            UsersOdsReaderWriter obj = new UsersOdsReaderWriter();
            obj.removeOdsRow(file);
            
            Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new requestor to ods | 2 to delete from ods | 3 to view from ods: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.addToODS(file);
                    break;
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
    
    
//    REquestor's Story Options
    @Override
    public void storyOptions(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for creating new attribute | 2 for changing attributes: ");
        int choice = sc.nextInt();
       if(choice == 1){
           createStory();
       }else if(choice == 2){
           changeAttributes();
       }else{
           System.out.println("Wrong entry!!!");
       }
    }
    
    //Story methods using the story ods file test.ods
    
    public void createStory() {
        File file = new File("test.ods");
        StoryOdsReaderWriter obj = new StoryOdsReaderWriter();
        obj.addToODS(file);
    }
    
    public void changeAttributes() {
        File file = new File("test.ods");
        StoryOdsReaderWriter obj = new StoryOdsReaderWriter();
        obj.changeODS(file);
    }
    
}
