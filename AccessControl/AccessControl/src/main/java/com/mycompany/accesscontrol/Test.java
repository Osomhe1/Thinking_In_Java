/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.accesscontrol;

/**
 *
 * @author OSIOKE
 */
public class Test {

    public static void main(String[] args) {
        // test class
        for (int i=0 ; i<10; i++){
            Connection ref = ConnectionManager.makeConnectionManger();
            if(ref != null){
                System.out.println("Connection" + (i + 1) + ref.getStatus());
            }
            else{
                System.out.println("Connection Manager runs out");
            }
        }
    }
    
}


class ConnectionManager {
  
    private static Connection[] cnns = new Connection[8];
    private  static int topPos = 0;
    public ConnectionManager () {}

    public static Connection makeConnectionManger() {
        if(topPos < cnns.length){
            cnns[ topPos ] = Connection.creatConnection();
            return cnns[ topPos++ ];
        }
        else{
            return null;
        }
        
    }
}


class Connection{
    private String flag = " done";
    private Connection() {}
    public String getStatus(){
        return flag;
    }
    public static Connection creatConnection () {
        return new Connection();
    }
}

