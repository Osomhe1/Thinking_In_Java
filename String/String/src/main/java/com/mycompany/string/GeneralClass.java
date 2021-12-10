/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.string;

/**
 *
 * @author OSIOKE
 */
public class GeneralClass {
    
    // public static void main(String[] args) {
        
    // }
    
    public void   IntField(int itf ){
         itf = 1234;
        
    }

    public void LongField(){
        long lf = 333333L;
    }

    public void FloatField(){
        float ff = 4.4F;
    }

    public void DoubleField(){
        double dd = 3.4;
    }

    public void StringField(){
        String ss = "This is string";
    }

    public static void main(String[] args) {
        System.out.print(itf.toString());
        System.out.print(lf.toString());
        System.out.print(ff.toString());
        System.out.print(dd.toString());
        System.out.print(ss.toString());
    }
}

