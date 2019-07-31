package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Collection;
import java.util.Comparator;

public class cartSortingComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {

        Integer item1Quantity = new Integer(item1.getQuantity());
        Integer item2Quantity = new Integer(item2.getQuantity());

        return item1Quantity.compareTo(item2Quantity);
    }

}
