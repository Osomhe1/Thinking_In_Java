/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.resuingclass;

/**
 *
 * @author OSIOKE
 */
class Insect{
    int i = 9;
    int j;
    Insect() {
        prt("i = " + i  + ",  j = " + j);
        j=39;
    }

    static int x1 = prt("static Insect .x1 initialized");
    static int prt(String s){
        System.out.println(s);
        return 47;
    }
}


class Beetle extends Insect{
    int k = prt("Beetle.k initialized");
    Beetle(){
        prt("k = " + k);
        prt("j = " + j);
    }
    static int x2 = prt("static Beetle.x2 initialized");

}


public class LadyBugs extends Beetle {
    int v = prt("LadyBugs.v initialized");
    LadyBugs(){
        prt("v = " + v);
        prt("k = " + k);
        prt("j = " + j);
        
    }
    static int x3 = prt("static LadyBugs.x3 initialized");
    public static void main(String[] args) {
            prt("LadyBugs constructor");
            // LadyBugs l = new LadyBugs();
            
        }
    
}
