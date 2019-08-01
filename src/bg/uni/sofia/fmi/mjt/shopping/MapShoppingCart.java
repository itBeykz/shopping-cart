package bg.uni.sofia.fmi.mjt.shopping;

import java.util.*;

public class MapShoppingCart implements ShoppingCart {

    private Comparator<Item> SortingComparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            Integer item1 = o1.getQuantity();
            Integer item2 = o2.getQuantity();
            String item1name = o1.getName();
            String item2name = o2.getName();
            int quantityCompare = item1.compareTo(item2);
            int nameCompare = item1name.compareTo(item2name);
            if (nameCompare == 0)
                return ((quantityCompare == 0) ? quantityCompare : quantityCompare);
            else
                return nameCompare;

        }
    };
    private Map<Item, Integer> shoppingMap = new TreeMap<Item, Integer>(SortingComparator);
    private double total;

    public MapShoppingCart() {
        total = 0;
    }


    @Override
    public Collection<Item> getUniqueItems() {
        List<Item> shoppingList = Collections.list(Collections.enumeration(shoppingMap.keySet()));
        List<Item> tempList = new LinkedList<>();
        for (Item item : shoppingList)
            if (item.getQuantity() == 1)
                tempList.add(item);


        System.out.println(System.currentTimeMillis());
        return tempList;
    }

    @Override
    public Collection<Item> getSortedItems() {
        System.out.println(System.currentTimeMillis());
        return sortByValue(shoppingMap);
    }

    @Override
    public void addItem(Item item) {

        if (item == null) {
            throw new ItemNotFoundException("Invalid item");
        } else if (shoppingMap.containsKey(item)) {
            shoppingMap.put(item, item.getQuantity() + 1);
            total += item.getPrice();
            System.out.println("Item added in the map!");
        } else {
            shoppingMap.put(item, item.getQuantity());
            total += item.getPrice();
            System.out.println("Item added in the map!");
        }
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void removeItem(Item item) throws ItemNotFoundException {
        if (item == null) {
            throw new ItemNotFoundException("Invalid item");
        } else if (shoppingMap.containsKey(item)) {
            shoppingMap.put(item, item.getQuantity() - 1);
            total -= item.getPrice();
            item.setQuantity(item.getQuantity() - 1);

        } else {
            System.out.println("No such item in the basket");
        }
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public double getTotal() {
        System.out.println(System.currentTimeMillis());
        return this.total;
    }


    public static Collection<Item> sortByValue(Map<Item, Integer> hm) {

        List<Item> tempList = Collections.list(Collections.enumeration(hm.keySet()));
        return tempList;
    }

    @Override
    public void print() {
        for (Map.Entry<Item, Integer> entry : shoppingMap.entrySet())
            System.out.println("Key = " + entry.getKey().getName() +
                    ", Value = " + entry.getValue());
    }
}
