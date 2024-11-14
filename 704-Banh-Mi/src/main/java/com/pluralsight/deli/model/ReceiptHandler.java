package com.pluralsight.deli.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptHandler {

    public static void printReceipt(Order order) {
        // Get current time for receipt naming and formatting
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDate = now.format(formatter);

        // Create the file path for the receipt
        String receiptFilePath = "receipts/" + formattedDate + ".txt";
        File receiptFile = new File(receiptFilePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            writer.write("704 Banh Mi\n");
            writer.write("Customer: " + order.getCustomerName() + "\n");
            writer.write("Date and Time: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("Items Ordered:\n");

            for (OrderItem item : order.getItems()) {
                writer.write(item.getClass().getSimpleName() + " - $" + item.getPrice() + "\n");
            }

            writer.write("Total Price: $" + order.calculateTotalPrice() + "\n");

            System.out.println("Receipt saved to " + receiptFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}