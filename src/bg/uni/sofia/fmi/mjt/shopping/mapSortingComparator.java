package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Comparator;
import java.util.Map;

public class mapSortingComparator implements Comparator<Map.Entry<Item, Integer>> {
    @Override
    public int compare(Map.Entry<Item, Integer> o1,
                       Map.Entry<Item, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }

}
