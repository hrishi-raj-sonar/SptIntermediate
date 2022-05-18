///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.syntech.sptintermediate;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// *
// * @author hrishi
// */
//public class AllUsersTest {
//
//    @Test
//    public void testGetAllUsersRequestors() {
//
//        List<Requestors> list = new ArrayList();
//        Requestors r = new Requestors(0, "admin", "admin@gmail.com");
//        Requestors r1 = new Requestors(1, "Ram", "ram@gmail.com");
//        Requestors r2 = new Requestors(2, "Sita", "sita@gmail.com");
//        list.add(r1);
//        list.add(r2);
//        String expResult = "1  Ram  ram@gmail.com\n2  Sita  sita@gmail.com\n";
//        String result = r.getAllUsers(list);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllUsersRequestorsWrongExpected() {
//
//        List<Requestors> list = new ArrayList();
//        Requestors r1 = new Requestors(1, "Ram", "ram@gmail.com");
//        Requestors r2 = new Requestors(2, "Sita", "sita@gmail.com");
//        Requestors r = new Requestors(0, "admin", "admin@gmail.com");
//        list.add(r1);
//        list.add(r2);
//        String expResult = "1  Ram  ram@gmail.com\n2  Sita  sita@gmail.com";
//        String result = r.getAllUsers(list);
//        assertNotEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllUsersDevelopers() {
//
//        List<Developers> list = new ArrayList();
//        Developers d = new Developers(0, "admin", "admin@gmail.com");
//        Developers d1 = new Developers(1, "Ram", "ram@gmail.com");
//        Developers d2 = new Developers(2, "Sita", "sita@gmail.com");
//        list.add(d1);
//        list.add(d2);
//        String expResult = "1  Ram  ram@gmail.com\n2  Sita  sita@gmail.com\n";
//        String result = d.getAllUsers(list);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllUsersDevelopersWrong() {
//
//        List<Developers> list = new ArrayList();
//        Developers d = new Developers(0, "admin", "admin@gmail.com");
//        Developers d1 = new Developers(1, "Ram", "ram@gmail.com");
//        Developers d2 = new Developers(2, "Sita", "sita@gmail.com");
//        list.add(d1);
//        list.add(d2);
//        String expResult = "1  Ram  ram@gmail.com 2  Sita  sita@gmail.com";
//        String result = d.getAllUsers(list);
//        assertNotEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllUsersReviewers() {
//
//        List<Reviewers> list = new ArrayList();
//        Reviewers r = new Reviewers(0, "admin", "admin@gmail.com");
//        Reviewers r1 = new Reviewers(1, "Ram", "ram@gmail.com");
//        Reviewers r2 = new Reviewers(2, "Sita", "sita@gmail.com");
//        list.add(r1);
//        list.add(r2);
//        String expResult = "1  Ram  ram@gmail.com\n2  Sita  sita@gmail.com\n";
//        String result = r.getAllUsers(list);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllUsersReviewersWrong() {
//
//        List<Reviewers> list = new ArrayList();
//        Reviewers r = new Reviewers(0, "admin", "admin@gmail.com");
//        Reviewers r1 = new Reviewers(0, "admin", "admin@gmail.com");
//        Reviewers r2 = new Reviewers(2, "Sita", "sita@gmail.com");
//        list.add(r1);
//        list.add(r2);
//        String expResult = "1  Ram  ram@gmail.com\n2  Sita  sita@gmail.com\n";
//        String result = r.getAllUsers(list);
//        assertNotEquals(expResult, result);
//    }
//}