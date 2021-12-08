/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.controlexecution;

/**
 *
 * @author OSOMHE
 */
public class Fabinoacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int count = 7;
        int num1 = 0;
        int num2 = 1;

        System.out.println("Fibonacci Series of "+count+" numbers:");

        int i = 1;
        while(i <= count){
            System.out.print(num1+ "");
            int sumOfPrevTwo = num1 = num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
            i++;
        }
    }
    
}
