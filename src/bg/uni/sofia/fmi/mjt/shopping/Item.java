package bg.uni.sofia.fmi.mjt.shopping;

public interface Item {
    String getName();

    String getDescription();

    double getPrice();

    int getQuantity();

    void setQuantity(int quantity);
}
