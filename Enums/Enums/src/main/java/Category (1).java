/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author OSOMHE
 */

//package enumerated;
//import static Input.STOP;
//import static Input.DIME;
//import static Input.DOLLAR;
//import static Input.NICKEL;
//import static Input.QUARTER;
import Second_Question.VendingMachine2;
import java.util.*;



 public enum Category11 {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(PRODUCT),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private static EnumMap<VendingMachine2.Input11,Category11> categories = new EnumMap<VendingMachine2.Input11,Category11>(VendingMachine2.Input11.class);

    static {
        for(Category11 c : Category11.class.getEnumConstants()) {
            for(VendingMachine2.Input11 type : c.values){
                categories.put(type, c);
            }
        }
    }

    public static Category11 categorize(VendingMachine2.Input11 input) {
        return categories.get(input);
    }

    private VendingMachine2.Input11[] values;
    Category11(VendingMachine2.Input11... types) { values = types; }

    public static void main(String[] args){
        System.out.println(Category11.MONEY);
        System.out.println(Category11.categories);
    }
}
