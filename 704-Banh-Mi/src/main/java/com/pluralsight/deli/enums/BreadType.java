package com.pluralsight.deli.enums;

// Enum representing different bread types available for sandwiches
public enum BreadType {
    WHITE(5.50), WHEAT(5.50), RYE(5.50), WRAP(5.50), BAGUETTE(5.50);

    private double price;

    // Constructor to set the price for each bread type
    BreadType(double price) {
        this.price = price;
    }

    // Get the price based on sandwich size
    public double getPriceForSize(int size) {
        if (size == 8) return price + 1.50;  // Additional price for 8-inch sandwich
        if (size == 12) return price + 2.00; // Additional price for 12-inch sandwich
        return price; // Default price for 4-inch sandwich
    }
}

