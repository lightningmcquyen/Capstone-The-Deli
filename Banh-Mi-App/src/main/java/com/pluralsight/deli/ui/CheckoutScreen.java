package com.pluralsight.deli.ui;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.OrderProcessor;
import com.pluralsight.deli.model.ReceiptHandler;

public class CheckoutScreen {

    public static void displayCheckoutScreen(Order order) {
        System.out.println("----- Checkout -----");

        // Print the receipt for the order
        ReceiptHandler.printReceipt(order);
    }
}
