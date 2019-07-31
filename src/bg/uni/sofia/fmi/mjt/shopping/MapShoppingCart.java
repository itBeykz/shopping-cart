package bg.uni.sofia.fmi.mjt.shopping;

import java.util.*;

public class MapShoppingCart implements ShoppingCart {

    private Map<Item, Integer> shoppingMap = new HashMap<>();
    private double total;
    private static int counter = 2;

    public MapShoppingCart() {
        total = 0;
    }


    @Override
    public Collection<Item> getUniqueItems() {
        List<Item> shoppingList = Collections.list(Collections.enumeration(shoppingMap.keySet()));
for(Item item : shoppingList)
    System.out.println(item.getName());
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
            shoppingMap.put(item, counter++);
            total += item.getPrice();
            System.out.println("Item added in the map!");
        } else {
            shoppingMap.put(item, 1);
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
            shoppingMap.remove(item);
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

        List<Map.Entry<Item, Integer>> list =
                new LinkedList<>(hm.entrySet());

        Collections.sort(list, new mapSortingComparator());


        Map<Item, Integer> temp = new HashMap<>();
        for (Map.Entry<Item, Integer> product : list) {
            temp.put(product.getKey(), product.getValue());
        }

        List<Item> tempList = Collections.list(Collections.enumeration(temp.keySet()));
        return tempList;
    }

    @Override
    public void print() {
        for (Map.Entry<Item, Integer> entry : shoppingMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
