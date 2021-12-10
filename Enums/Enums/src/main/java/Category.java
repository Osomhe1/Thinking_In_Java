
//import default_package.VendingMachine;


import java.util.EnumMap;

public enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(PRODUCT),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private static EnumMap<VendingMachine.Input,Category> categories = new EnumMap<VendingMachine.Input,Category>(VendingMachine.Input.class);

    static {
        for(Category c : Category.class.getEnumConstants()) {
            for(VendingMachine.Input type : c.values){
                categories.put(type, c);
            }
        }
    }

    public static Category categorize(VendingMachine.Input input) {
        return categories.get(input);
    }

    static int categorize(Input input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private VendingMachine.Input[] values;
    Category(VendingMachine.Input... types) { values = types; }

    public static void main(String[] args){
        System.out.println(Category.MONEY);
        System.out.println(Category.categories);
    }
}
