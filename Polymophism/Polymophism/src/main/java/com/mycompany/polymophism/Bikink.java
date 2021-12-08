package com.mycompany.polymophism;


class Cycle{
    // public void travel() {
        
    // }

    private String name = "Cycle";

    public static void travel(Cycle c) {
        System.out.println("Cycle.ride(" + c);
    }
    public String toString(){
        return this.name;
    }
}

class Unicycle extends Cycle{

    private String name = "Unicycle";

    public void balance() {
        System.out.println("Balance Unicycle");
    }

    public String toString() {
        return this.name;
    }
}

class Bicycle extends Cycle{
    private String name = "Bicycle";


    public void balance() {
        System.out.println("Balance Bycicle");
    }

    public String toString(){
        return this.name;
    }
}


public class Bikink {
    public static void main(String[] args) {
        Cycle[] ride = {new Unicycle(), new Bicycle()};

        ((Unicycle) ride[0]).balance();
        ((Bicycle) ride[1]).balance();
    }
}
