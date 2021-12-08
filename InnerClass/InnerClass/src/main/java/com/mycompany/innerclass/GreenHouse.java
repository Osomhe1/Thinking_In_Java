/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.innerclass;

//import Controller2.*;
import org.w3c.dom.events.Event;

/**
 *
 * @author OSIOKE
 */
public class GreenHouse extends Controller2 {

    private boolean water = false;
    public class WaterMixerOn extends Event{
        public WaterMixerOn(long delayTime) {super();}
        public void action() {
            water = true;
        }
        public String toString(){ return "Water Mixer is on";}
    }   
    
    public class WaterMixerOff extends Event{
        public WaterMixerOff (long delayTime){ super();}
        public void action() {water = false;}
        public String toString(){ return "Water mixer is Off";}
    }
    public class Restart extends Event{
        private Event[] eventList;
        public Restart (long delayTime, Event[] eventList){ super();
        this.eventList = eventList;
        for(Event e: eventList)
            // e.start();
            addEvent(e);
        
        // start();
        // addEvent(this);
    }
        public void action(){
            for(Event e: eventList){
                ((GreenHouseController) e).start();
                addEvent(e);
            }
            start();
            addEvent(this);

            // addEvent(new Restart(delayTime));
        }
        public String toString() {return "Restarting!!";}
    }
    public static class Terminate extends Event {
        public Terminate(long delayTime){super();}
        public void action() {
            System.exit(0);
        }
        public String toString(){return "Terminating";}
    }
    
    public static void main(String[] args) {
        GreenHouse gh = new GreenHouse();
                            // ghc.addEvent(ghc)
                            Event[] eventList = {
                                (Event) gh.new WaterMixerOff(500),
                                (Event) gh.new WaterMixerOn(700)
                            };
                gh.addEvent(gh.new Restart(3000, eventList));
                if(args.length == 1)
                gh.addEvent((Event) new GreenHouse.Terminate(
                    new Integer(args[0])
                ));
                gh.run();
            }

    public void start() {
    }

    // private void
    //  addEvent(Event e) ;
    // }
    // {

    private void addEvent(GreenHouse.Restart restart) {
    }

    private void run() {
    }
}

