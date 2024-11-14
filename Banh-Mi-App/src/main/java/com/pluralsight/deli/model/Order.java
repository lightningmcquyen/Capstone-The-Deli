package com.pluralsight.deli.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customerName;
    private List<OrderItem> items = new ArrayList<>();
    private double totalPrice;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}