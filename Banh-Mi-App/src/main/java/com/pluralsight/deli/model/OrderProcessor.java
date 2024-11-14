package com.pluralsight.deli.model;

import com.pluralsight.deli.util.PromptMaker;

public class OrderProcessor {

    // Method to process the order
    public static void processOrder() {
        // Step 1: Get the customer's name
        String customerName = PromptMaker.promptForCustomerName();
        Order order = new Order(customerName);  // Create a new order for the customer

        // Step 2: Prompt the user for a sandwich
        Sandwich sandwich = PromptMaker.promptForSandwich();  // Prompt for sandwich selection
        order.addItem(sandwich);  // Add the sandwich to the order

        // Step 3: Prompt the user if they want to add a drink
        if (PromptMaker.promptForAddDrink()) {
            Drink drink = PromptMaker.promptForDrink();  // Prompt for drink selection
            order.addItem(drink);  // Add the drink to the order
        }

        // Step 4: Prompt the user if they want to add chips
        if (PromptMaker.promptForAddChips()) {
            Chips chips = PromptMaker.promptForChips();  // Prompt for chips selection
            order.addItem(chips);  // Add the chips to the order
        }

        // Step 5: Print the receipt for the order
        ReceiptHandler.printReceipt(order);  // Print the order receipt
    }
}