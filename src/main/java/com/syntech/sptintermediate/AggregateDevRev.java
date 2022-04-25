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
public class AggregateDevRev {
    
    Developer dev = new Developer();
    Reviewer rev = new Reviewer();
    
    public Developer createInstanceDeveloper(){
        return dev;
    }
    
    public Reviewer createInstanceReviewer(){
        return rev;
    }
}
