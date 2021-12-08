/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.holdingobject;

import java.util.*;

/**
 *
 * @author OSOMHE
 */
public class RandomShape {
    public static class Shape {
        public void draw() {}
        public void erase() {}
    }
    public static class Circle extends Shape {
        public void draw() { System.out.println("Circle.draw()"); }
        public void erase() { System.out.println("Circle.erase()"); }
    }
    public static class Square extends Shape {
        public void draw() { System.out.println("Square.draw()"); }
        public void erase() { System.out.println("Square.erase()"); }
    }
    public static class Triangle extends Shape {
        public void draw() { System.out.println("Triangle.draw()"); }
        public void erase() { System.out.println("Triangle.erase()"); }
    }
    public static class RandomShapeGenerator implements Iterable<Shape> {
        private Random rand = new Random();
        private final int size;
        public RandomShapeGenerator(int num) {
            size = num;
        }
        public Iterator<Shape> iterator() {
            return new Iterator<Shape>() {
                private int index = 0;
                public boolean hasNext() {
                    return index < size;
                }
                public Shape next() {
                    index++;
                    switch(rand.nextInt(3)) {
                        default:
                        case 0: return new Circle();
                        case 1: return new Square();
                        case 2: return new Triangle();
                    }
                }
            };
        }
    }
    public static void main(String[] args) {
        int shapeNum = 10;
        RandomShapeGenerator gen = new RandomShapeGenerator(shapeNum);
        for (Shape s : gen) {
            s.draw();
        }
    }
}
