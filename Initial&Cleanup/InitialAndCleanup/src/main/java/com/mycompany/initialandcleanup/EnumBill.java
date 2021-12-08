/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.initialandcleanup;

/**
 *
 * @author OSOMHE
 */
public class EnumBill {

    public enum Bills {
        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
    }
    public static void main(String[] args) {
        for(Bills b : Bills.values()){
            System.out.println("Value: ");
            switch(b){
                case ONE : System.out.println("$1");
                break;
                case FIVE : System.out.println("$5");
                break;
                case TEN : System.out.println("$10");
                break;
                case TWENTY : System.out.println("$20");
                break;
                case FIFTY : System.out.println("$50");
                break;
                case HUNDRED : System.out.println("$100");
                default: break;
            }

        }
        
    }
    
}
