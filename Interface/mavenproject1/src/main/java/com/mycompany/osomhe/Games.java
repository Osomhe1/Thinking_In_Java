/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.osomhe;
import java.util.*;

/**
 *
 * @author OSOMHE
 */
 interface Game {
     void play();
    
}

interface GameFactory {
   Game getGame();
}

class CoinToss implements Game {
    Random rand = new Random();
    public void play() {
        System.out.println("Toss Coin");
        switch(rand.nextInt(2)){
            case 0: System.out.println("Heads"); return;
            case 1: System.out.println("Tails"); return;
            default: System.out.println("OnEdge"); return;
        
    }
    }
    
    public static GameFactory factory = 
            new GameFactory(){
        public Game getGame() {
            return new CoinToss();
        }
    };
}
class DiceThrow implements Game {
	Random rand = new Random();
	public void play() { 
		System.out.print("Throw Dice: " + (rand.nextInt(6) + 1));		
	}
	public static GameFactory factory =
		new GameFactory() {
			public Game getGame() { return new DiceThrow(); }
		};
}

            
public class Games {
	public static void playGame(GameFactory factory) {
		Game g = factory.getGame();
		g.play();
	}



    
    public static void main(String [] args){
        playGame(CoinToss.factory);
        playGame(DiceThrow.factory);
    }
}

