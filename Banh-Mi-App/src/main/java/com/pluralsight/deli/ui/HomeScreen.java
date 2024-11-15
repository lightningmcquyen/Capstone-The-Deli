package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.Order;
import com.pluralsight.deli.application.UtilMethods;

public class HomeScreen {

    public static void displayHomeScreen() {
        System.out.println("Welcome to 704 Banh Mi!");
        System.out.println("Please choose an option:");
        System.out.println("1. Start a new order");
        System.out.println("0. Exit");

        // Using a loop to handle invalid input instead of recursion
        int choice;
        do {
            choice = UtilMethods.promptForChoice(1); // Get user choice (0 or 1)

            // Handle user's choice
            switch (choice) {
                case 1 -> {
                    startNewOrder();  // Start a new order
                    return;  // Exit the loop once the order starts
                }
                case 0 -> {
                    System.out.println("Thank you for visiting! Goodbye.");
                    System.exit(0);  // Exit the application
                }
                default -> System.out.println("Invalid choice. Please try again.");
                // Continue to prompt user for a valid input
            }
        } while (true);  // Loop until the user chooses to exit
    }

    private static void startNewOrder() {
        // Prompt user for name before starting the order
        String customerName = UtilMethods.promptForString("Enter your name: ");  // Prompt for the name

        // Create a new Order object with the customer name
        Order order = new Order(customerName);  // Pass name to Order constructor
        System.out.println("Order created: " + order.getCustomerName());
        OrderScreen.displayOrderScreen(order); // Redirect to OrderScreen
    }
}
