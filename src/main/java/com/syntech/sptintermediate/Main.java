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

                switch (choice1) {
                    case 1:
                        dev.listOptions();
                        break;
                    case 2:
                        dev.jdbcOptions();
                        break;
                    case 3:
                        dev.odsOptions();
                        break;
                }

                dev.storyOptions();

                break;
            case 2:
                System.out.println("Welcome reviewer: ");
                Reviewers rev = new Reviewers(1, "Hari", "hari@gmail.com");

                System.out.println("1 for List | 2 for Jdbc | 3 for Ods : ");
                int choice2 = sc.nextInt();

                switch (choice2) {
                    case 1:
                        rev.listOptions();
                        break;
                    case 2:
                        rev.jdbcOptions();
                        break;
                    case 3:
                        rev.odsOptions();
                        break;
                }

                rev.storyOptions();
                break;
            case 3:
                System.out.println("Welcome requestor: ");
                Requestors req = new Requestors(1, "shyam", "shyam@gmail.com");

                System.out.println("1 for List | 2 for Jdbc | 3 for Ods : ");
                int choice3 = sc.nextInt();

                switch (choice3) {
                    case 1:
                        req.listOptions();
                        break;
                    case 2:
                        req.jdbcOptions();
                        break;
                    case 3:
                        req.odsOptions();
                        break;
                }

                req.storyOptions();
                break;
            default:
                System.out.println("Wrong entry!");
        }
    }
}
