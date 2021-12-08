package com.mycompany.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


 class Com{
    private static final class StringTuple implements Comparable<StringTuple> {
        private final String v1;
        private final String v2;
        private StringTuple(String v1, String v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        public int compareTo(StringTuple target) {
            return v1.compareTo(target.v1);
        }
        public boolean equals(Object o) {
            if (o == this) { return true; }
            if (! (o instanceof StringTuple)) {
                return false;
            }
            StringTuple target = (StringTuple)o;
            return target.v1.equals(v1);
        }
        public int hashCode() { // field second is not involved
            int result = 17;
            result = result * 31 + v1.hashCode();
            return result;
        }
        public String toString() {
            return "T[" + v1 + "," + v2 + "]";
        }
        private static final int DEFAULT_LENGTH= 2;
        public static Generator<StringTuple> generator() {
            return generator(DEFAULT_LENGTH);
        }
        public static Generator<StringTuple> generator(int strLength) {
            return new Generator<StringTuple>() {
                private Generator<String> gen = StringGenerator.newInstance(strLength);
                public StringTuple next() {
                    return new StringTuple(gen.next(),gen.next());
                }
            };
        }
    }
    private static final Generator<StringTuple> GEN = StringTuple.generator();
    private static StringTuple[] stringTupleArray(int size) {
        StringTuple[] array = new StringTuple[size];
        for (int i = 0; i < size; i++) {
            array[i] = GEN.next();
        }
        return array;
    }
    private static List<StringTuple> stringTupleList(int size) {
        List<StringTuple> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(GEN.next());
        }
        return list;
    }
    public static void SectionB() {
        int size = 10;
        Set<StringTuple> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(GEN.next());
        }
        Iterator<StringTuple> ite = set.iterator();
        StringTuple firstTuple = ite.next(); // get the first element
        System.out.println("Set: " + set + "\n" + "contains element: " + firstTuple + "? " + set.contains(firstTuple));
    }
    public static void SectionC() {
        int size = 100;
        Map<StringTuple,Integer> tupleDic = new HashMap<>(); // count the occurrence of each StringTuple
        StringTuple tempTuple = null;
        for (int i = 0; i < size; i++) {
            tempTuple = GEN.next();
            if (tupleDic.containsKey(tempTuple)) {
                tupleDic.put(tempTuple,tupleDic.get(tempTuple)+1);
            } else {
                tupleDic.put(tempTuple,1);
            }
        }
        System.out.println(tupleDic);
    }
    public static void main(String[] args) {
        SectionB();
        SectionC();
    }
}



//interface Generator<T> {
//    public T next();
//}

final class StringGenerator implements Generator<String> {
    private static final int DEFAULT_LENGTH = 7;
    private static Generator<String> GEN = null;
    private final char[] UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] LOWER = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final Random R = new Random();
    private final int STR_LENGTH;
    private StringGenerator(int size) { STR_LENGTH = size; }
    public static Generator<String> newInstance() { // pre-charge Singleton
        if (GEN == null) {
            GEN = new StringGenerator(DEFAULT_LENGTH);
        }
        return GEN;
    }
    public static Generator<String> newInstance(int size) { // the only public factory return Generator interface
        return new StringGenerator(size);
    }
    public String next() {
        StringBuilder sb = new StringBuilder();
        sb.append(UPPER[R.nextInt(UPPER.length)]);
        for (int i = 0; i < STR_LENGTH-1; i++) {
            sb.append(LOWER[R.nextInt(LOWER.length)]);
        }
        return sb.toString();
    }
}


