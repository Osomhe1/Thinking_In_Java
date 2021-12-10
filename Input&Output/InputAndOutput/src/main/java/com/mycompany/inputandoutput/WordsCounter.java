/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.inputandoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author OSIOKE
 */
public class WordsCounter {

    /**
     * @param args the command line arguments
     */
    private static void countWords(String w, Map<String, Integer> words) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    void CountWords(String filename, Map<String, Integer> words) throws FileNotFoundException{
        Scanner file = new Scanner(new File(filename));
        while(file.hasNext()){
            String word = file.next();
            Integer count = words.get(word);
            if(count != null){
                count++;
            }else{
                count = 1;
                words.put(word, count);
            }
        }
        file.close();
    } 

    public static void main(String args[]){
        Map<String, Integer> words = new HashMap<String, Integer>();
        countWords("\\w+", words);
        System.out.println(words);

    }
    
}
