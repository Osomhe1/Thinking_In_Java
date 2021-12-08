/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.everythingisanobject;

/**
 *
 * @author OSIOKE
 */
public class Scope {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int x = 12;
        // Only x available

        int q = 96;
        // Both x & q available

        // Only x available
        // q is "out of scope"
        System.out.println(q * x);

    }
}
