package com.pluralsight.deli.ui;

import com.pluralsight.deli.model.BanhMiApp;
import com.pluralsight.deli.util.PromptMaker;

public class HomeScreen {

    // Method to display the home screen and handle user's initial choice
    public static void displayHomeScreen() {
        System.out.println("Welcome to the Banh Mi Sandwich Shop!");
        System.out.println("Please choose an option:");
        System.out.println("1. Start a new order");
        System.out.println("2. View existing order");
        System.out.println("3. Exit");

        int choice = PromptMaker.promptForChoice(3); // Prompt user for their choice (up to 3 options)

        // Handle user's choice
        switch (choice) {
            case 1:
                // Start a new order, which will navigate to the SandwichScreen
                BanhMiApp.startNewOrder();
                break;
            case 2:
                // View existing order, this will allow the user to see their current order
                BanhMiApp.viewExistingOrder();
                break;
            case 3:
                // Exit the application
                System.out.println("Thank you for visiting! Goodbye.");
                System.exit(0); // Terminate the application
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayHomeScreen(); // Loop back to the home screen if the input is invalid
        }
    }
}