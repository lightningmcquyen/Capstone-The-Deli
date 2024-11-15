package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.Order;
import com.pluralsight.deli.application.UtilMethods;

public class OrderScreen {

    public static void displayOrderScreen(Order order) {
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("""
       🥪 ORDER 🥪
    ==================
    1. Add Sandwich
    2. Add Drink
    3. Add Chips
    4. Checkout
    0. Cancel Order
    ==================
    """);

            int choice = UtilMethods.promptForChoice(4); // Get user choice (0 to 4)

            switch (choice) {
                case 1:
                    SandwichScreen.displaySandwichScreen(order);
                    break;
                case 2:
                    DrinkScreen.displayDrinkScreen(order);
                    break;
                case 3:
                    ChipsScreen.displayChipsScreen(order);
                    break;
                case 4:
                    CheckoutScreen.displayCheckoutScreen(order);
                    continueOrdering = false; // End the process after checkout
                    break;
                case 0:
                    System.out.println("Canceling order...");
                    // Cancel the order and return to HomeScreen
                    HomeScreen.displayHomeScreen();
                    continueOrdering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}