/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

/**
 *
 * @author hrishi
 */
interface IAllUsers { //this is an extra to show static and default functions in interfaces
    

    static void printa(){
        System.out.println("Hello fish");
    }
    
    default void printaa(){
        System.out.println("Hello fishes");
    }
}
