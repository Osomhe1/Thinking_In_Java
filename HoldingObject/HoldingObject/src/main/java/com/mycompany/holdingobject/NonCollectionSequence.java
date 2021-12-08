package com.mycompany.holdingobject;


//import Pet ;
import java.util.*;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Random;

/**
 *
 * @author OSIOKE
 */
class PetSequence {
 protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {
 public Iterable<String>  reversed() {
 return new Iterable<String>() {
public Iterator<String> iterator() {
return new Iterator<String>() {
//    either pets.length or words.length
int current = pets.length - 1;
public boolean hasNext() { return current > -1; }
 public String next() { return words[current--]; }
public void remove() { // Not implemented
 throw new UnsupportedOperationException();

 //private int index = 0;
 //public boolean hasNext() {
 //return index < pets.length;
 }
};
}
};
}
 public Iterable<String> randomized() {
 return new Iterable<String>() {
 public Iterator<String> iterator() {
 List<String> shuffled =
 new ArrayList<String>(Arrays.asList(words));
 Collections.shuffle(shuffled, new Random(47));
 return shuffled.iterator();
 }
 };
 }

 public static void main(String[] args) {
 NonCollectionSequence nc = new NonCollectionSequence();
for(String s : nc.reversed())
System.out.print(s + " ");
 System.out.println();
for(String s : nc.randomized())
System.out.print(s + " ");
 System.out.println();
//for(String s : nc)
// System.out.print(s + " ");
 //InterfaceVsIterator.display(nc.iterator());
 }
} 
