package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.Order;
import com.pluralsight.deli.application.ReceiptHandler;
import com.pluralsight.deli.application.UtilMethods;

public class CheckoutScreen {

    public static void displayCheckoutScreen(Order order) {
        // Display the details of the current order
        System.out.println("Your Order Summary:");
        System.out.println(order);  // Assuming the toString method is properly formatted

        // Display total price
        System.out.println("Total Price: $" + order.getTotalPrice());

        // Confirm and display receipt
        if (UtilMethods.promptForYesNo("Would you like to confirm your order? (yes/no)")) {
            // Print receipt to console (optional)
            ReceiptHandler.printReceipt(order);

            // Save receipt to CSV
            ReceiptHandler.saveReceiptToCSV(order);  // Ensure this is called to save to CSV file

            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Cancelling your order...");
            HomeScreen.displayHomeScreen();  // Go back to home screen
        }
    }
}