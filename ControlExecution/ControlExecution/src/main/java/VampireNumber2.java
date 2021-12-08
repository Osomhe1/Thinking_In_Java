/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


//import VampireNumber;

/**
 *
 * @author OSOMHE
 */
public class VampireNumber2 {

    /**
     * @param args the command line arguments
     * 
     * 
     */
    
    private int vampire = 0;
  private int t1 = 0;
  private int t2 = 0;

    public VampireNumber2(int number) throws IllegalArgumentException
{
    // Vampire = number;
    // Vampire = number;
    int n1 = number / 100;
    int n2 = number % 100;
        t1 = n1 /10;
        t2 = n1 % 10;
    int  t3 = n2 / 10;
    int  t4 = n2 % 10;

    if (number == calc(t1, t2, t3, t4)) return;
    if (number == calc(t1, t2, t4, t3)) return;
    if (number == calc(t2, t1, t3, t4)) return;
    if (number == calc(t2, t1, t4, t3)) return;
    if (number == calc(t1, t3, t2, t4)) return;
    if (number == calc(t1, t3, t4, t2)) return;
    if (number == calc(t3, t1, t2, t4)) return;
    if (number == calc(t3, t1, t4, t2)) return;
    if (number == calc(t1, t4, t2, t3)) return;
    if (number == calc(t1, t4, t3, t2)) return;
    if (number == calc(t4, t1, t2, t3)) return;
    if (number == calc(t4, t1, t3, t2)) return;

        throw new IllegalArgumentException("not a vampire number");


}

 private static int calc (int n1, int n2, int n3, int n4) {
     int t1; 
     int t2; 
     t1 = n1 * 10 + n2;
     t2 = n3 * 10 + n4;

     return t1 * t2;

 }
 public String toString(){
     return vampire + " = " + t1 + " * " + t2 ;
 }
    
    public static void main(String[] args) {
        // TODO code application logic here
//        {
      for (int number = 1000; number < 10000; number++){
          try {
              VampireNumber2 vn = new VampireNumber2(number);
            //   VampireNumber vn = new VampireNumber(number);
              System.out.println(vn.toString());
          } catch (IllegalArgumentException e) {
          }
      }
//  }
    }
    
}
