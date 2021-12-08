/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.osomhe;

/**
 *
 * @author OSOMHE
 */
interface Cycle {
    void ride();
}

interface CycleFactory{
	Cycle getCycle();
}

class Unicycle implements Cycle{
    public void ride(){
        System.out.println("Riding Unicycle");
    }
    
}

class UniFactory implements CycleFactory{
    public Cycle getCycle() {
        return new Unicycle();
    }
 
}

class Bicycle implements Cycle{
    public void ride(){
        System.out.println("Riding Bicycle");
    }
}

class BiFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Bicycle();
    }
}



class Tricycle implements Cycle{
    public void ride(){
        System.out.println("Riding Tricycle");
    }
}

class TriFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Tricycle();
    }
}

public class Interface{
    public static void rideCycle(CycleFactory factory){
        Cycle c = factory.getCycle();
        c.ride();
    }
    public static void main(String args[]){
        rideCycle(new UniFactory());
        rideCycle(new BiFactory());
        rideCycle(new TriFactory());
    }
}
