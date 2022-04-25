/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author hrishi
 */
public class Main {

//    Developers d = new Developers(1, "Ram", "ram@gmail.com");
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 for developer, 2 for reviewer, 3 for requestor: ");
        int currentUser = sc.nextInt();

        switch (currentUser) {
            case 1:
                System.out.println("Welcome developer!");
                Developers dev = new Developers(1, "Ram", "ram@gmail.com");
                
                System.out.println("1 for List | 2 for Jdbc | 3 for Ods : ");
                int choice1 = sc.nextInt();
                
                switch(choice1){
                    case 1:
                        developerListOptions(dev);
                        break;
                    case 2 :
                        developerJdbcOptions();
                        break;
                    case 3:
                        developerOdsOptions();
                        break;
                }
                
                DeveloperStoryOptions(dev);
                
                break;
            case 2:
                System.out.println("Welcome reviewer: ");
                Reviewers rev = new Reviewers(1, "Hari", "hari@gmail.com");
                
                System.out.println("1 for List | 2 for Jdbc | 3 for Ods : ");
                int choice2 = sc.nextInt();
                
                switch(choice2){
                    case 1:
                        reviewerListOptions(rev);
                        break;
                    case 2 :
                        reviewerJdbcOptions();
                        break;
                    case 3:
                        reviewerOdsOptions();
                        break;
                }
                
                reviewerStoryOptions(rev);
                break;
            case 3:
                System.out.println("Welcome requestor: ");
                Requestors req = new Requestors(1, "shyam", "shyam@gmail.com");
                
                System.out.println("1 for List | 2 for Jdbc | 3 for Ods : ");
                int choice3 = sc.nextInt();
                
                switch(choice3){
                    case 1:
                        requestorListOptions(req);
                        break;
                    case 2 :
                        requestorJdbcOptions();
                        break;
                    case 3:
                        requestorOdsOptions();
                        break;
                }
                
                requestorStoryOptions(req);
                
                break;
            default:
                System.out.println("Wrong entry!");
                
        }
        
    }
    
    
    public static Developers createDevelopersObject() {

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

    public static void developerListOptions(Developers ram) {

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new developer to list | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Developers developerObj = createDevelopersObject();
                    ram.addUser(developerObj);
                    break;
                case 2:
                    System.out.println("What developer to remove? : ");
                    int removeUserId = sc.nextInt();
                    ram.removeUser(removeUserId);
                    break;
                case 3:
                    ram.viewAllUsers();
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

    public static void developerJdbcOptions() throws SQLException {
        MySqlConnection m = new MySqlConnection();
        m.establishConnection();

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new developer to database | 2 to delete from | 3 to view from list: ");
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
    
    public static void developerOdsOptions() {
        File file = new File("developers.ods");
            UsersOdsReaderWriter obj = new UsersOdsReaderWriter();
            obj.removeOdsRow(file);
    }
    
    public static void DeveloperStoryOptions(Developers dev){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for starting a story | 2 for finishing a story | 3 for delivering a story : ");
        int choice = sc.nextInt();
       if(choice == 1){
           dev.startStory();
       }else if(choice == 2){
           dev.finishStory();
       }else if(choice == 3){
           dev.deliverStory();
       }else{
           System.out.println("Wrong entry!!!");
       }
    }
    
    
    public static void reviewerListOptions(Reviewers hari) {

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new reviewer to list | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Reviewers reviewerObj = createReviewersObject();
                    hari.addUser(reviewerObj);
                    break;
                case 2:
                    System.out.println("What developer to remove? : ");
                    int removeUserId = sc.nextInt();
                    hari.removeUser(removeUserId);
                    break;
                case 3:
                    hari.viewAllUsers();
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
    
    public static Reviewers createReviewersObject() {

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
//        System.out.println(d.id + " " + d.name + " " + d.email + " " + d.userRole);
//        d.addUser(d
    
    public static void reviewerJdbcOptions() throws SQLException {
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
    
    public static void reviewerOdsOptions() {
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
    
    public static void reviewerStoryOptions(Reviewers rev){
        
        Scanner sc = new Scanner(System.in);
        
        rev.reviewStory();
    }
    
    public static void requestorListOptions(Requestors shyam) {

        Scanner sc = new Scanner(System.in);

        int flag = 1;
        while (flag == 1) {
            System.out.println("1 to add new requestor to list | 2 to delete from | 3 to view from list: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Requestors requestorObj = createRequestorsObject();
                    shyam.addUser(requestorObj);
                    break;
                case 2:
                    System.out.println("What  to remove? : ");
                    int removeUserId = sc.nextInt();
                    shyam.removeUser(removeUserId);
                    break;
                case 3:
                    shyam.viewAllUsers();
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
    
    public static Requestors createRequestorsObject() {

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
    
    public static void requestorJdbcOptions() throws SQLException {
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
    
    public static void requestorOdsOptions() {
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
    
    public static void requestorStoryOptions(Requestors req){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for creating new attribute | 2 for changing attributes: ");
        int choice = sc.nextInt();
       if(choice == 1){
           req.createStory();
       }else if(choice == 2){
           req.changeAttributes();
       }else{
           System.out.println("Wrong entry!!!");
       }
    }
    
    
}
