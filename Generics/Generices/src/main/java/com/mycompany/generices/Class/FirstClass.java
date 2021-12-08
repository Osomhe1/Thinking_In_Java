package com.mycompany.generices.Class;

//import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//import java.util.function.Function;


public class FirstClass {
    private static interface InDistance<T extends InDistance<? super T>> { 
        public double distance(T t);
    }
    private static class PointOne implements InDistance<PointOne> {
        private static final String TYPENAME = "1D Point";
        private static int count = 0;
        private final int ID = ++count;
        private final String NAME = TYPENAME + "#" + ID;
        protected int x;
        public PointOne(int num) {
            x = num;
        }
        public String toString() {
            return NAME + ": [" + x + "]";
        }
        public int getX() {
            return x;
        }
        public int setX(int position) {
            int old = x;
            x = position;
            return old;
        }
        public double distance(PointOne p) {
            return (double) Math.abs(getX() - p.getX());
        }
    }
    private static class PointTwo extends PointOne implements InDistance<PointOne> {
        private static final String TYPENAME = "2D Point";
        private static int count = 0;
        private final int ID = ++count;
        private final String NAME = TYPENAME + "#" + ID;
        protected int y;
        public PointTwo(int numX) {
            super(numX);
        }
        public PointTwo(int numX, int numY) {
            super(numX);
            y = numY;
        }
        public String toString() {
            return NAME + ": [" + x + "," + y + "]";
        }
        public int getY() {
            return y;
        }
        public int setY(int positionX, int positionY) {
            int old = positionX;
            y = positionY;
            return old;
        }
        public double distance(PointOne p) {
            if (p instanceof PointTwo) {
                @SuppressWarnings("unchecked")
                PointTwo twoDp = (PointTwo)p;
                return Math.sqrt( Math.pow( ( this.getX() - twoDp.getX() ), 2 ) + Math.pow( ( this.getY() - twoDp.getY() ), 2 ) );
            }
            return super.distance(p);
        }
    }

    private static class Function {
        private static <T extends InDistance<? super T>> double totalDistance(Collection<T> c) {
            double totalDistance = 0.0;
            if (c.size() < 2) {
                return totalDistance;
            }
            Iterator<T> ite = c.iterator();
            T previousPoint = ite.next(); // length > 2, must have point
            while (ite.hasNext()) {
                T currentPoint = ite.next();
                totalDistance += currentPoint.distance(previousPoint);
            }
            return totalDistance;
        }
    }
    private static class TestUnit {
        private static Random r = new Random();
        private static final int MAX = 50;
        private static int random() {
            return r.nextInt(MAX);
        }
        private static PointOne createOneD() {
            return new PointOne(random());
        }
        private static PointTwo createTwoD() {
            return new PointTwo(random(),random());
        }
        private static List<PointOne> oneDList(int size) {
            List<PointOne> result = new ArrayList<PointOne>();
            for ( int i = 0; i < size; i++) {
                result.add(createOneD());
            }
            return result;
        }
        private static List<PointTwo> twoDList(int size) {
            List<PointTwo> result = new ArrayList<PointTwo>();
            for ( int i = 0; i < size; i++) {
                result.add(createTwoD());
            }
            return result;
        }
        private static List<PointOne> mixList(int size) {
            boolean typeFlag = true;
            List<PointOne> result = new ArrayList<PointOne>();
            for ( int i = 0; i < size; i++) {
                if (typeFlag) {
                    result.add(createOneD());
                } else {
                    result.add(createTwoD());
                }
                typeFlag = !typeFlag;
            }
            return result;
        }
        private static void testPoint() {
            PointOne onePa = createOneD();
            PointOne onePb = createOneD();
            System.out.println("Distance of " + onePa + " AND " + onePb + " is: " + onePa.distance(onePb));
            PointTwo twoPa = createTwoD();
            PointTwo twoPb = createTwoD();
            System.out.println("Distance of " + twoPa + " AND " + twoPb + " is: " + twoPa.distance(twoPb));
            System.out.println("Distance of " + twoPa + " AND " + onePa + " is: " + twoPa.distance(onePa));
        }
        private static void testFunction() {
            int size = 10;
            List<PointOne> oneDList = oneDList(size);
            List<PointTwo> twoDList = twoDList(size);
            List<PointOne> mixList = mixList(size);
            System.out.println("Total Distance:     " + Function.totalDistance(oneDList));
            System.out.println("Total Distance:     " + Function.totalDistance(twoDList));
            System.out.println("Total Distance:     " + Function.totalDistance(mixList));
        }
    }
    public static void main(String[] args) {
        TestUnit.testPoint();
        TestUnit.testFunction();
    }
}
