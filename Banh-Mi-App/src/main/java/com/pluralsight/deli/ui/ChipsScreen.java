package com.pluralsight.deli.ui;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.OrderProcessor;

public class ChipsScreen {

    public static void displayChipsScreen(Order order) {
        System.out.println("----- Chips Selection -----");

        // Process chips order
        Chips chips = OrderProcessor.processChips();

        // Add chips to order
        order.addItem(chips);

        System.out.println("Your chips have been added!");
    }
}