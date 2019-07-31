package bg.uni.sofia.fmi.mjt.shopping;

import java.util.*;

public class ListShoppingCart implements ShoppingCart {

    private List<Item> shoppingList = new LinkedList<Item>();
    private double total;


    public ListShoppingCart() {
        total = 0;
    }

    @Override
    public Collection<Item> getUniqueItems() {
        List<Item> tempShoppingList = new LinkedList<>();
        for (Item item : shoppingList)
            if (item.getQuantity() == 1)
                tempShoppingList.add(item);


        System.out.println(System.currentTimeMillis());

        return tempShoppingList;
    }

    @Override
    public Collection<Item> getSortedItems() {
        ownSort(shoppingList);
        System.out.println(System.currentTimeMillis());
        return shoppingList;
    }

    @Override
    public void addItem(Item item) {
        if (item == null) {
            throw new ItemNotFoundException("Invalid item");
        } else if (shoppingList.contains(item)) {
            shoppingList.add(item);
            item.setQuantity(item.getQuantity() + 1);
            total += item.getPrice();
            System.out.println("Item added in the list!");
        } else {
            shoppingList.add(item);
            total += item.getPrice();
            System.out.println("Item added in the list!");
        }
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void removeItem(Item item) throws ItemNotFoundException {
        if (item == null) {
            throw new ItemNotFoundException("Invalid item");
        } else if (Collections.frequency(shoppingList, item) > 1) {
            shoppingList.remove(item);
            item.setQuantity(item.getQuantity() - 1);
            total -= item.getPrice();
        } else {
            shoppingList.remove(item);
            total -= item.getPrice();
        }
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public double getTotal() {
        System.out.println(System.currentTimeMillis());
        return this.total;
    }


    public void ownSort(Collection<Item> collection) {
        List<Item> tempShoppingList = new ArrayList<Item>();
        tempShoppingList.addAll(collection);
        tempShoppingList.sort(new cartSortingComparator());

        collection.clear();
        collection.addAll(tempShoppingList);
        System.out.println(System.currentTimeMillis());

    }

    @Override
    public void print() {

        for (int i = 0; i < shoppingList.size(); i++) {

            System.out.println(shoppingList.get(i).getName());
            System.out.println(System.currentTimeMillis());
        }
    }
}
