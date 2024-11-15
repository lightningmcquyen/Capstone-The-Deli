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

    public static void printReceipt(Order order) {
        String currentDateTime = getCurrentDateTime();

        // Print header
        System.out.println("""
        -----------------------------
        Receipt for: %s
        Date: %s
        -----------------------------
        """.formatted(order.getCustomerName(), currentDateTime));

        // Print items
        for (OrderItem item : order.getItems()) {
            System.out.println(String.format("%s - $%.2f", item.getDescription(), item.getPrice()));
        }

        // Print total
        System.out.println("-----------------------------");
        System.out.printf("Total Price: $%.2f\n", order.getTotalPrice());
        System.out.println("-----------------------------");
    }

    // Helper method to get the current date and time formatted as mm/dd/yyyy hh:mm
    private static String getCurrentDateTime() {
        // Format the current date and time using the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}