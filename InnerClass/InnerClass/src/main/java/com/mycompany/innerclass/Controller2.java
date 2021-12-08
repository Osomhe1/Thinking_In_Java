/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.innerclass;

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
import java.util.*; 
import org.w3c.dom.events.Event;

/**
 *
 * @author OSOMHE
 */
public class Controller2 {
    
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) {
        eventList.add(c);
    }
    public void run(Collection<? extends Event> EventList) {
        while(eventList.size() > 0) {
            for(Event e: new ArrayList<Event>(eventList))
            if(e.ready()) {
                System.out.println(e);
                e.action();
                eventList.remove(e);
            }
        }
    }
    
}
