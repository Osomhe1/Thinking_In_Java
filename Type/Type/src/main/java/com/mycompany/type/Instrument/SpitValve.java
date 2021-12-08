/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.type.Instrument;

import java.lang.reflect.Method;

/**
 *
 * @author OSIOKE
 */
abstract class Instrument{
    public void play(){
        System.out.println(this.getClass().getSimpleName()+ " is playing!!");
    }
}

class Stringed extends Instrument{}

class Percussion extends Instrument{}

class Wind extends Instrument{
    public void cleanSpitValve(){
        System.out.println(this.getClass().getSimpleName()+" is cleaning the spit valve!");
    }
}

public class SpitValve{
    public static void main(String args[]){ 
        Instrument ip = new Percussion();
        Instrument  ss = new Stringed();
        Instrument wd = new Wind();

        ip.play();
        ss.play();
        wd.play();

        try{
            Class <?> c= wd.getClass();
            Method m = c.getMethod("cleanSpitValve");
            m.invoke(wd);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
