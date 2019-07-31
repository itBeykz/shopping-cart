package bg.uni.sofia.fmi.mjt.shopping;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String name) {
        super(name);
    }
}
