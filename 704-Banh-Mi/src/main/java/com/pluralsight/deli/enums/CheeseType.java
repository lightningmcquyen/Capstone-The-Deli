package com.pluralsight.deli.enums;

// Enum representing different cheese types for sandwiches
public enum CheeseType {
    AMERICAN(0.75), PROVOLONE(0.75), CHEDDAR(0.75), SWISS(0.75), PATE(1.00);

    private double price;

    // Constructor to set the price for each cheese type
    CheeseType(double price) {
        this.price = price;
    }

    // Get the price based on sandwich size
    public double getPriceForSize(int size) {
        if (size == 8) return price + 0.75;  // Additional price for 8-inch sandwich
        if (size == 12) return price + 1.50; // Additional price for 12-inch sandwich
        return price; // Default price for 4-inch sandwich
    }
}

