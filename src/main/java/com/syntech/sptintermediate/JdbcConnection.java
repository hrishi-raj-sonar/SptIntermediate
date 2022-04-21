/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author hrishi
 */
public abstract class JdbcConnection {
    
    Connection con;
    
    abstract String getJdbcDriverClass();
    
    abstract String getJdbcURL();
    
    abstract String getUserName();
    
    abstract String getPassword();
    
    public void establishConnection() {
        try {
            Class.forName(getJdbcDriverClass());

//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/Students", "root", "toor");

            con = DriverManager.getConnection(getJdbcURL(), getUserName(), getPassword());

//            con.close();
            //return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        //return null;
    }
    
    public void read() throws SQLException{
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3) + " " + rs.getString(4));
            }
    }
    
    public void add() throws SQLException{
//        PreparedStatement stmt = con.prepareStatement("INSERT INTO Std_1 (userID, userName, date_of_birth, ObtainedMarks) VALUES (103, 'Ramesh', '1999-09-04',99)");
   
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id : ");
        int userID = sc.nextInt();
        System.out.println("Enter name : ");
        String userName = sc.next();
        System.out.println("Enter Email : ");
        String userEmail = sc.next();
        System.out.println("Enter Role : ");
        String userRole = sc.next();
        
        PreparedStatement stmt = con.prepareStatement("INSERT INTO user (userID, userName, userEmail, userRole) VALUES (?,?,?,?)");
        stmt.setInt(1,userID);//1 specifies the first parameter in the query  
        stmt.setString(2,userName);  
        stmt.setString(3, userEmail);
        stmt.setString(4, userRole);
        int i=stmt.executeUpdate();  
        System.out.println(i+" records inserted");  
    }
    
    public void delete() {
        try {
            String delete = "DELETE FROM user WHERE userID = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id of the record you want to delete : ");
            int id = sc.nextInt();
            
            stmt.setInt(1, id);
            int i = stmt.executeUpdate();
            System.out.println(i+" records deleted"); 
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void findById() {
        try {
            String select = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement stmt = con.prepareStatement(select);
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id of the record you want to view : ");
            int id = sc.nextInt();
            
            stmt.setInt(1, id);
            System.out.println("Here's record of id "+ id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3) + " " + rs.getString(4));
            }
            
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
