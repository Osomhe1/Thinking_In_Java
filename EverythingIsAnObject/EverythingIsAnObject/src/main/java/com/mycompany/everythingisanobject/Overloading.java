/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.everythingisanobject;

/**
 *
 * @author OSIOKE
 */
class Tree {
    int height;

    Tree() {
        System.out.print("Planting a seedling");
        height = 0;
    }

    Tree(int initialHeight) {
        height = initialHeight;
        System.out.print("Creating new Tree that is " +
                height + " feet tall");
    }

    void info() {
        System.out.print("Tree is " + height + " feet tall");
    }

    
    /** 
     * @param s
     */
    void info(String s) {
        System.out.print(s + ": Tree is " + height + " feet tall");
    }
}

public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        // Overloaded constructor:
        new Tree();
    }
}
