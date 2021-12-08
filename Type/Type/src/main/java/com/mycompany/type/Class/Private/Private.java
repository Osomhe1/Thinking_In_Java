/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.type.Class.Private;

/**
 *
 * @author OSOMHE
 */
 class Squre {
    protected double num = 50;
    private int circle(int a){
      return a*a;
    }
}

public class Private{
  public static void main(String args[]){
    Squre obj = new Squre();
    System.out.println(obj.num);
    System.out.println(obj.circle(10));
  }
}
