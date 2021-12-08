 public class OuterClass {
    class  Inner {}
    
 class InnerClass extends OuterClass{
     
    // System.out.println("From InnerClassOne");
 }
 class InnerClass2 extends OuterClass.Inner{
//  from depper inner class
 }

 public static void main(String[] args) {
     
//   
}

}

