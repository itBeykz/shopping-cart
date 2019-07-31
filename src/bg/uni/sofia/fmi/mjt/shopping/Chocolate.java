package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Objects;

public class Chocolate implements Item {

    private String name;
    private String description;
    private double price;
    private static int quantity=0;


    public Chocolate(String name, String description, double price) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity++;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;
        if (!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item) obj;

        return item.getName().equals(name) &&
                item.getDescription().equals(description) &&
                item.getPrice() == price;
    }
}
