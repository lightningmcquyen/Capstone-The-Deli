package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.Order;
import com.pluralsight.deli.application.Drink;
import com.pluralsight.deli.application.UtilMethods;

public class DrinkScreen {

    public static void displayDrinkScreen(Order order) {
        // Prompt user for drink options
        Drink drink = new Drink(); // Create a new drink object

        // Prompt for drink size and flavor
        drink.setSize(UtilMethods.promptForDrinkSize());
        drink.setFlavor(UtilMethods.promptForUserInput("Enter drink flavor: "));

        order.addItem(drink); // Add the drink to the order

        // After adding the drink, return to the previous screen or continue adding other items
        System.out.println("Your drink has been added to the order.");
    }
}
