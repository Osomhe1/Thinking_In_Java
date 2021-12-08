/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.type.Class.Protected;

/**
 *
 * @author OSOMHE
 */
public class Protected {

    protected int subTwoNumbs(int a, int b){
        return a-b;
    }
    
}

class Test extends Protected{
    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println(obj.subTwoNumbs(30, 10));
    }
}

