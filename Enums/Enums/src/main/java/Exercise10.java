/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OSOMHE
 */
import java.util.*;

public class Exercise10 {
    public static void main(String[] args) {
        VendingMachine vm1=new VendingMachine();
        Generator<Input> gen=new RandomInputGenerator();
        vm1.run(gen);
        vm1.reset();
        vm1.run(gen);
        
        VendingMachine vm2=new VendingMachine();
        vm2.run(gen);
    }
}

