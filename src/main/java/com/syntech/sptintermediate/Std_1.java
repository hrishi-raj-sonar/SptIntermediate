/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author hrishi
 */

@Entity
public class Std_1 {
    
    @Id
    int id;
    String name;
    String date_of_birth;
    int ObtainedMarks;

    @Override
    public String toString() {
        return "Std_1{" + "id=" + id + ", name=" + name + ", date_of_birth=" + date_of_birth + ", ObtainedMarks=" + ObtainedMarks + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setObtainedMarks(int ObtainedMarks) {
        this.ObtainedMarks = ObtainedMarks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public int getObtainedMarks() {
        return ObtainedMarks;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.date_of_birth);
        hash = 59 * hash + this.ObtainedMarks;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Std_1 other = (Std_1) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ObtainedMarks != other.ObtainedMarks) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.date_of_birth, other.date_of_birth)) {
            return false;
        }
        return true;
    }
    
//    public static void main(String[] args) {
//        Std_1 s = new Std_1();
//        Std_1 t = new Std_1();
//        s.setId(1);
//        s.setName("Dinesh");
//        s.setDate_of_birth("2010-10-24");
//   
//        System.out.println(s.toString());
//        System.out.println(s.getDate_of_birth());
//        
//        System.out.println(t.equals(s));
//        System.out.println(s.hashCode());
//        System.out.println(t.hashCode());
//    }
}
