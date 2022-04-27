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
public class Developers extends AllUsers<Developers> {
    
     
    public Developers(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void setUserRole() {
        super.userRole = "Developer";
    }

    private ArrayList<Developers> a = new ArrayList();

    
    public void viewAllUsers() {
        super.viewAllUsers(a);
    }

    private void addUser(Developers d) {
        this.a.add(d);
    }

    private void removeUser(int id) {
        Developers d = null;
        
        for (Developers a1 : a){
            if(a1.id == id){
               d = a1; 
            }
        }
        
        System.out.println("Removing developer with id " + id);
        a.remove(d);
//        a.removeIf(d -> d.id == id);
    }

    //    Developer's list options
    @Override
    public void listOptions() {

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new developer to list | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Developers developerObj = createDevelopersObject();
                    addUser(developerObj);
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

//    Creating developers objects for list 
    private static Developers createDevelopersObject() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter developer id: ");
        int id = sc.nextInt();

        System.out.println("Enter developer name: ");
        String name = sc.next();

        System.out.println("Enter developer email: ");
        String email = sc.next();

        Developers developerObject = new Developers(id, name, email);
        developerObject.setUserRole();

        return developerObject;
    }

//    Developer's JDBC Options
    @Override
    public void jdbcOptions() throws SQLException {
        MySqlConnection m = new MySqlConnection();
        m.establishConnection();

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new developer to database | 2 to delete | 3 to view : ");
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

//    Developer's ods options
    @Override
    public void odsOptions() {
        File file = new File("developers.ods");
        UsersOdsReaderWriter obj = new UsersOdsReaderWriter();
        obj.removeOdsRow(file);
    }

//    Developer's story options
    @Override
    public void storyOptions() {

        Scanner sc = new Scanner(System.in);
        System.out.println("1 for starting a story | 2 for finishing a story | 3 for delivering a story : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                startStory();
                break;
            case 2:
                finishStory();
                break;
            case 3:
                deliverStory();
                break;
            default:
                System.out.println("Wrong entry!!!");
                break;
        }
    }

    //Story methods using the story ods file test.ods
    private static void startStory() {
        File file = new File("test.ods");
        StoryOdsReaderWriter obj = new StoryOdsReaderWriter();
        obj.startStory(file);
    }

    private static void finishStory() {
        File file = new File("test.ods");
        StoryOdsReaderWriter obj = new StoryOdsReaderWriter();
        obj.finishStory(file);
    }

    private static void deliverStory() {
        File file = new File("test.ods");
        StoryOdsReaderWriter obj = new StoryOdsReaderWriter();
        obj.deliverStory(file);
    }
}
