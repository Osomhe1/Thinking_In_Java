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
import java.util.*;




public enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values;
    Category(Input... types) { values = types; }
    private static EnumMap<Input,Category> categories = new EnumMap<Input,Category>(Input.class);

    static {
        for(Category c : Category.class.getEnumConstants()) {
            for(Input type : c.values){
                categories.put(type, c);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
