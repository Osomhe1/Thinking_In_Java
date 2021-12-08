/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.inputandoutput;

import java.util.prefs.Preferences;

/**
 *
 * @author OSIOKE
 */
public class BaseDirectory {

    /**
     * @param args the command line arguments
     */
     public static void main (String args[]){
        Preferences root=Preferences.useRoot();
//        root.clear();
        byte[] info = root.getByteArray("base directory", "/User".getBytes());
        System.out.println(new String(info));
        info="/User/Wei".getBytes();
        root.putByteArray("base directory", info);
        System.out.print(new String(root.getByteArray("base directory", "/users".getBytes())));
    }
}
