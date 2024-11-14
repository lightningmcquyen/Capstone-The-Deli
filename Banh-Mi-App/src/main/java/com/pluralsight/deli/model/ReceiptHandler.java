package com.pluralsight.deli.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptHandler {

    public static void printReceipt(Order order) {
        // Format current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        String dateTime = dateFormat.format(new Date());

        System.out.println("----- RECEIPT -----");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Items:");

        // Print item descriptions and prices
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getDescription() + ": $" + item.getPrice());
        }

        System.out.println("Total: $" + order.getTotalPrice());
        System.out.println("------------------");
    }
}