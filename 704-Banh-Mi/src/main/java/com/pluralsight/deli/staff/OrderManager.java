package com.pluralsight.deli.staff;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<MenuItem> items;

    // Constructor to initialize the list of items
    public OrderManager() {
        items = new ArrayList<>();
    }

    // Method to add an item to the order
    public void addItem(MenuItem item) {
        items.add(item); // Add item to the order list
    }

    // Method to display the order details
    public void displayOrderDetails() {
        double totalPrice = 0;
        System.out.println("Order Details:");
        for (MenuItem item : items) {
            item.displayDetails(); // Display each item's details
            totalPrice += item.getPrice(); // Add item price to the total
        }
        System.out.println("Total: $" + totalPrice); // Display total price
    }
}