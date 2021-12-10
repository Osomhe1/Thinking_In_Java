/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.anotation;

/**
 *
 * @author OSIOKE
 */
package com.vogella.junit.first;

//import net.mindview.atunit.*;

import org.junit.jupiter.api.Test;

//import net.mindview.util.*; 
//import org.junit.jupiter.api.Assertions;
//import jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Test;
public class StackLStringTest extends StackL<String> {
    
//    Test for string

    @Test
    void _push() {
        push("one");
        assert top().equals(1);
        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals(2);
        assert pop().equals(1);
    }

    @Test
    void _top() {
        push("Egg");
        push("Eight");
        assert top().equals("Egg");
        assert top().equals("Egg");
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "Testing");
    }

    private Object top() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void push(String b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class OSExecute {

        private static void command(String b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public OSExecute() {
        }
    }
}
