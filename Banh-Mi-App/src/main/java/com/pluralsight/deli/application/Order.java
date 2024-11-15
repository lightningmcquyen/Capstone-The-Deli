package com.pluralsight.deli.application;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customerName;
    private List<OrderItem> items = new ArrayList<>();
    private double totalPrice;

    // Constructor with customer name
    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    // Default constructor if needed (could be used for creating empty orders)
    public Order() {
        this.customerName = "Guest"; // Default name or empty string
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Add an item to the order
    public void addItem(OrderItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    // Get all items in the order
    public List<OrderItem> getItems() {

        return items;
    }

    // Get total price of the order
    public double getTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("""
                Order for: %s
                Order: %s
                """, customerName, items);
    }
}