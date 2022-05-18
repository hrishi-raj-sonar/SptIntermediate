/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.util;

import java.util.Scanner;

/**
 *
 * @author hrishi
 */
public class Validation {
    
    public static Boolean validateString(String str) {
        return (str != null && !str.isEmpty());
    }
    
    public static void main(String[] args) {
        String id = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println(validateString(id));
        
        while(validateString(id)){
            System.out.println("Enter your name: ");
            id = sc.next();
        }
    }
}
