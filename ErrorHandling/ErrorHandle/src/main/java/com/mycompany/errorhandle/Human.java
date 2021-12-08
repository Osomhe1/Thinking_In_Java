package com.mycompany.errorhandle;



//import java.io.*;
// import static net.mindview.util.Print.*; 
//import java.util.Scanner;

public class Human {
    public static class Annoyance extends RuntimeException {
        private static final long serialVersionUID = 0;
    }
    public static class Sneeze extends Annoyance {
        private static final long serialVersionUID = 0;
    }
    public static void wrapException(int exceptionNum) {
        try {
            switch (exceptionNum) {
                case 1: throw new Annoyance();
                case 2: throw new Sneeze();
                default: return;
            }
        } catch(Sneeze e) {
            throw new RuntimeException(e);
        } catch(Annoyance e) {
            throw new RuntimeException(e);
        }
    }
 public static void main(String[] args) {
 // Catch the exact type:
 for(int i : new int [] {1,2}) {
 try {
 throw new Sneeze();
 } catch(Sneeze s) {
 System.out.println("Caught Sneeze");
 } catch(Annoyance a) {
 System.out.println("Caught Annoyance"); 
}
 // Catch the base type:
 try {
 throw new Sneeze();
 } catch(Annoyance a) {
 System.out.println("Caught Annoyance");
 }
 }
 }
}
