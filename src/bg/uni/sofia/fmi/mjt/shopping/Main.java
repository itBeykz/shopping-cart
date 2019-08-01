package bg.uni.sofia.fmi.mjt.shopping;

public class Main {

    public static void main(String[] args) {

        ShoppingCart mapCart = new MapShoppingCart();
        Item apple1 = new Apple("Apple", "red", 1);
        Item apple2 = new Apple("Apple", "red", 1);
        Item apple3 = new Apple("Apple", "red", 1);
        Item apple4 = new Apple("Apple", "red", 1);
        Item chocolate = new Chocolate("Chocolate", "dark", 3.5);
        Item chocolate1 = new Chocolate("Chocolate", "dark", 3.5);
        mapCart.addItem(chocolate);
        mapCart.addItem(apple1);
        mapCart.removeItem(apple1);
        mapCart.removeItem(chocolate);
        mapCart.print();
        System.out.println(mapCart.getUniqueItems());

    }
}
