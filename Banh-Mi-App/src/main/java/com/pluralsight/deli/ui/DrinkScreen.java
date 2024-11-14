package com.pluralsight.deli.ui;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.OrderProcessor;

public class DrinkScreen {

    public static void displayDrinkScreen(Order order) {
        System.out.println("----- Drink Selection -----");

        // Process drink order
        Drink drink = OrderProcessor.processDrink();

        // Add drink to order
        order.addItem(drink);

        System.out.println("Your drink has been added!");
    }
}