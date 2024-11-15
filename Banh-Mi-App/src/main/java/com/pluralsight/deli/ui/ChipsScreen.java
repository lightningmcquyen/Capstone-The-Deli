package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.Order;
import com.pluralsight.deli.application.Chips;
import com.pluralsight.deli.application.UtilMethods;

public class ChipsScreen {

    public static void displayChipsScreen(Order order) {
        // Prompt user for chips options
        Chips chips = new Chips(); // Create a new chips object

        // Prompt for chips flavor
        chips.setFlavor(UtilMethods.promptUserChoice("Enter chips flavor: "));

        order.addItem(chips);

        // After adding the chips, you can return to the previous screen or continue adding other items
        System.out.println("Your chips have been added to the order.");
    }
}