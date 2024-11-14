package com.pluralsight.deli.ui;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.model.OrderProcessor;

public class SandwichScreen {

    public static void displaySandwichScreen(Order order) {
        System.out.println("----- Sandwich Selection -----");

        // Process sandwich order
        Sandwich sandwich = OrderProcessor.processSandwich();

        // Add sandwich to order
        order.addItem(sandwich);

        System.out.println("Your sandwich has been added!");
    }
}
