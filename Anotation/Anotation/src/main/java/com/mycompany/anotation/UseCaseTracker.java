/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.anotation;

import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
import java.util.*;

/**
 *
 * @author OSIOKE
 */
public class UseCaseTracker {
    // test
//    @Test 
 public static void 
 trackUseCases(List<Integer> useCases, Class<?> cl) {
 for(Method m : cl.getDeclaredMethods()) {
 useCases uc = m.getAnnotation(useCases.class);
 if(uc != null) {
 System.out.println(uc.description() + "Found Use Case:" + uc.id() +
         " ");
 useCases.remove(new Integer(uc.id()));
 }
 }
 for(int i : useCases) {
 System.out.println("Warning: Missing use case-" + i);
 }
 }
//  test
// assertThat(useCases, isNoEmpty());

 public static void main(String[] args) {
 List<Integer> useCases = new ArrayList<Integer>();
 Collections.addAll(useCases, 47, 48, 49, 50);
 trackUseCases(useCases, PasswordUtils.class);
 }

    private static class useCases {

        public useCases() {
        }

        private String description() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String id() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
