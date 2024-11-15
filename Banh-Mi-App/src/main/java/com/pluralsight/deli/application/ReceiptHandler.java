package com.pluralsight.deli.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptHandler {

    // File path for saving receipts
    private static final String RECEIPT_FILE_PATH = "receipts.csv";

    // This method saves the order details to a CSV file
    public static void saveReceiptToCSV(Order order) {
        // Prepare the receipt data with the current date and time
        String orderDetails = formatOrderForCSV(order);

        // Write the order details to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECEIPT_FILE_PATH, true))) {
            writer.write(orderDetails);
            writer.newLine();  // Add a new line after each receipt
            System.out.println("Receipt saved to CSV.");
        } catch (IOException e) {
            System.out.println("Error writing receipt to CSV: " + e.getMessage());
        }
    }

    // Formats the order details for CSV saving
    private static String formatOrderForCSV(Order order) {
        // Format the current date and time (mm/dd/yyyy hh:mm)
        String currentDateTime = getCurrentDateTime();

        // CSV Format: Date, Time, Name, Item 1 Description, Item 1 Price, Total Price
        StringBuilder csvLine = new StringBuilder();
        csvLine.append(currentDateTime).append(",");  // Date and time
        csvLine.append(order.getCustomerName()).append(",");  // Customer name

        // Add items details to the CSV line
        for (OrderItem item : order.getItems()) {
            csvLine.append(item.getDescription()).append(",");  // Item description
            csvLine.append(item.getPrice()).append(",");        // Item price
        }

        // Add the total price at the end
        csvLine.append("Total Price: ").append(order.getTotalPrice());

        return csvLine.toString();
    }

    // This method prints the receipt to the console
    public static void printReceipt(Order order) {
        String currentDateTime = getCurrentDateTime();
        System.out.println("Receipt for " + order.getCustomerName());
        System.out.println("Date: " + currentDateTime);
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getDescription() + " - $" + item.getPrice());
        }
        System.out.println("Total Price: $" + order.getTotalPrice());
    }

    // Helper method to get the current date and time formatted as mm/dd/yyyy hh:mm
    private static String getCurrentDateTime() {
        // Format the current date and time using the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}