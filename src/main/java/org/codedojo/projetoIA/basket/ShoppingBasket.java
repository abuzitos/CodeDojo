package org.codedojo.projetoIA.basket;

// ShoppingBasket.java
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public ShoppingBasket() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getQuantity(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item.getQuantity();
            }
        }
        return 0; // Item not found
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }

        if (total > 200) {
            total *= 0.90; // Apply 10% discount
        } else if (total > 100) {
            total *= 0.95; // Apply 5% discount
        }

        return total;
    }

    public static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new Item("Item A", 10.0, 5));
        basket.addItem(new Item("Item B", 25.0, 2));
        basket.addItem(new Item("Item C", 9.99, 6));

        System.out.println("Quantity of Item A: " + basket.getQuantity("Item A"));
        System.out.println("Total price of the basket: $" + basket.calculateTotalPrice());
    }
}