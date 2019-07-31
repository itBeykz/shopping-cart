package bg.uni.sofia.fmi.mjt.shopping;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ShoppingCart mapCart = new MapShoppingCart();
        Item apple1 = new Apple("Apple", "red", 1);
        Item apple2 = new Apple("Apple", "red", 1);
        //Item apple3 = new Apple("Apple", "red", 1);
        //Item apple4 = new Apple("Apple", "red", 1);
        Item chocolate = new Chocolate("Chocolate", "dark", 3.5);
        Item chocolate1 = new Chocolate("Chocolate","dark",3.5);
        mapCart.addItem(apple1);
        mapCart.addItem(apple2);
        mapCart.addItem(chocolate);
        mapCart.removeItem(apple1);
        mapCart.addItem(chocolate1);
        mapCart.removeItem(chocolate1);
        System.out.println(mapCart.getSortedItems());
       // System.out.println(mapCart.getUniqueItems());


    }
}
