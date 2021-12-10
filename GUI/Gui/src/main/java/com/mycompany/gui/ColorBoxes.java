/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author OSOMHE
 */
public class ColorBoxes extends JFrame {
    public ColorBoxes() {
        setTitle("Star");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
   
    
    Color getColor() {
         Random rand = new Random();
         
         int r = rand.nextInt(255);
         int g = rand.nextInt(255);
         int b = rand.nextInt(255);
         
         return new Color(r, g, b);
    
    }
    
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        
//        g.setColor(Color.CYAN);
//        g.drawOval(100, 100, 90, 90);
//        g.setColor(Color.ORANGE);
//        g.fillOval(100, 100, 90, 90);
//        g.setColor(Color.BLACK);
//        g.fillStar(120, 120, 100, 100);

        g2D.setColor(getColor());
//        g2D.fillPolygon(getColor());
        int[] x = {45, 52,72,52,60,40,15,28,9,32};
        int[] y = {28,62,68,80,105,85,102,75,58,60};
        g2D.fillPolygon(x, y, 10);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ColorBoxes s = new ColorBoxes();
        s.paint(null);
    }
    
}
