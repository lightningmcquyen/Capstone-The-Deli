package com.pluralsight.deli.model;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.OrderProcessor;
import com.pluralsight.deli.ui.*;
import com.pluralsight.deli.util.PromptMaker;
import java.util.Scanner;

public class BanhMiApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static Order currentOrder = null;  // Variable to hold the current order

    public static void main(String[] args) {
        System.out.println("Welcome to Banh Mi Deli!");

        // Prompt for customer name
        String customerName = PromptMaker.promptForCustomerName();

        // Create an order for the customer
        currentOrder = new Order(customerName);

        // Start the order process
        displayHomeScreen(currentOrder);
    }

    // Display the Home Screen
    private static void displayHomeScreen(Order order) {
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1) Order a Sandwich");
            System.out.println("2) Order a Drink");
            System.out.println("3) Order Chips");
            System.out.println("4) View your Order");
            System.out.println("5) Modify your Order");
            System.out.println("6) Checkout");
            System.out.println("7) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    OrderScreen.displayOrderScreen(order);
                    break;
                case 5:
                    OrderProcessor.modifyOrder(order); // Allow modification of order
                    break;
                case 6:
                    CheckoutScreen.displayCheckoutScreen(order);
                    continueOrdering = false; // End the process after checkout
                    break;
                case 7:
                    System.out.println("Exiting... Thank you for visiting Banh Mi Deli!");
                    continueOrdering = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Start a new order by creating a new Order object
    public static void startNewOrder() {
        // This method will start a new order and begin the process from scratch.
        System.out.println("Starting a new order...");

        // Reset the current order
        currentOrder = new Order(PromptMaker.promptForCustomerName());

        // Start the order flow from the home screen
        displayHomeScreen(currentOrder);
    }

    // View the existing order (display order details)
    public static void viewExistingOrder() {
        if (currentOrder == null) {
            System.out.println("No existing order found. Please start a new order.");
            return;
        }

        // Display the current order details
        OrderScreen.displayOrderScreen(currentOrder);
    }
}