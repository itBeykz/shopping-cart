package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Collection;
import java.util.Comparator;

public class cartSortingComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {


        return item1.getQuantity() - item2.getQuantity();
    }

}
