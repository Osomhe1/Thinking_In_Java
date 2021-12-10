package com.mycompany.mavenproject2;


//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author OSIOKE
 */

class EleToCompare{
    private int item;
    public EleToCompare(int n){
        item=n;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof EleToCompare){
            return this.item==((EleToCompare)o).item;
        }else{
            return false;
        }
        
    }
	@Override
    public int hashCode(){
        return item;
    }

    int getItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class Array2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
EleToCompare[] ea1=new EleToCompare[5];
        EleToCompare[] ea2=new EleToCompare[5];
        
        for(int i=0;i<5;i++){
            ea1[i]=new EleToCompare(10);
            ea2[i]=new EleToCompare(10);
        }
        
        System.out.println(ea1[1].equals(ea2[1]));
        System.out.println(Arrays.equals(ea1,ea2));
        
//        EleToCompare[] ea1=new EleToCompare[10];
        
        for(int i=0;i<ea1.length;i++){
            ea1[i]=new EleToCompare(i);
        }
        
        Arrays.sort(ea1,new EleToCompareComparator());
        System.out.println(Arrays.binarySearch(ea1,new EleToCompare(6),new EleToCompareComparator()));


   
}

}

