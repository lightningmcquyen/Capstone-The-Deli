package com.pluralsight.deli.ui;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.OrderItem;

public class OrderScreen {

    public static void displayOrderScreen(Order order) {
        System.out.println("\nYour Current Order:");

        // Loop through items and print descriptions
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getDescription() + ": $" + item.getPrice());
        }

        // Print total
        System.out.println("Total: $" + order.getTotalPrice());
    }
}