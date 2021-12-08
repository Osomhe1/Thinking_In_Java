/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Second_Question;
import java.util.*;
import java.io.*;


/**
 *
 * @author OSOMHE
 */
public class VendingMachine2 {

    private static class Generator<T> {

        public Generator() {
        }
    }

    enum StateDuration { TRANSIENT } // Tagging enum
    enum State {
        RESTING, ADDING_MONEY, DISPENSING(StateDuration.TRANSIENT), GIVING_CHANGE(StateDuration.TRANSIENT),
        TERMINAL;
        
        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true; }
        
    }
    
    private State state = State.RESTING;
    private int amount = 0;
    private Product selection = null;
    private EnumMap<State,StateMachine> em=new EnumMap<State,StateMachine>(State.class);
    
    private class StateMachine {
        void next(Input11 input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }
        void output() { System.out.println(amount); }
    }
    
    public VendingMachine2(String path) {
        Product.loadProducts(path);
        em.put(State.RESTING,new StateMachine(){
            void next(Input11 input) {
                switch(Category11.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = State.TERMINAL;
                    default:
                }
            }
        });
        em.put(State.ADDING_MONEY,new StateMachine(){
            void next(Input11 input) {
                switch(Category11.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = Product.randomSelection();
                        if(amount < selection.amount()){
                            System.out.println("Insufficient money for " + selection);
                        }
                        else state = State.DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = State.GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = State.TERMINAL;
                    default:
                }
            }
        });
        em.put(State.DISPENSING,new StateMachine(){
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = State.GIVING_CHANGE;
            }
        });
        em.put(State.GIVING_CHANGE,new StateMachine(){
            void next() {
                if(amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = State.TERMINAL;
            }
        });
        em.put(State.TERMINAL,new StateMachine(){
            void output() { System.out.println("Halted"); }
        });
    }
    
    public void reset(){
        state = State.RESTING;
        amount = 0;
        selection = null;
    }
    
    public void run(Generator<Input11> gen) {
        while(state != State.TERMINAL) {
            em.get(state).next(gen.next());
            while(state.isTransient){
                em.get(state).next();
            }
            em.get(state).output();
        }
    }
    
 
    
    
//    Categoty
    public enum Category11 {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(PRODUCT),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private static EnumMap<Input11,Category11> categories = new EnumMap<Input11,Category11>(Input11.class);

    static {
        for(Category11 c : Category11.class.getEnumConstants()) {
            for(Input11 type : c.values){
                categories.put(type, c);
            }
        }
    }

    public static Category11 categorize(Input11 input) {
        return categories.get(input);
    }

    private Input11[] values;
    Category11(Input11... types) { values = types; }

    public static void main(String[] args){
        System.out.println(Category11.MONEY);
        System.out.println(Category11.categories);
    }
}
    
//    Generator
    // For a basic sanity check:
    interface Generator2{
        
    }
    interface GenFactory{
        Generator2 getGenerator();
    }
 class RandomInputGenerator2 implements Generator2 {
    public Input11 next() { return Input11.randomSelection(); }
}


//input
public enum Input11 {

    
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), PRODUCT(0),
    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    
    int value; // In cents
    Input11(int value) { this.value = value; }
    Input11() {}
    int amount() { return value; }; // In cents
    static Random rand = new Random();
    public static Input11 randomSelection() {
        // Don’t include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}


//Text File

public class TextFile extends ArrayList<String> {
    // Read a file as a single string:
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in= new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if(get(0).equals("")) remove(0);
    }
    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }
}
// Exercise
public class Exercise11 {
    public static void main(String[] args) {
        VendingMachine2 vm=new VendingMachine2("/Users/java/thinkinjava/product.txt");
        Generator<Input11> gen;
        gen = new RandomInputGenerator2();
        vm.run(gen);
        
//        VendingMachine2 vm=new VendingMachine2("/Users/java/thinkinjava/product.txt");
        vm.run(new RandomInputGenerator2());
    }
}
}



