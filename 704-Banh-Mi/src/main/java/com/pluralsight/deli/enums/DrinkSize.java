package com.pluralsight.deli.enums;

// Enum representing different drink sizes
public enum DrinkSize {
    SMALL(2.00), MEDIUM(2.50), LARGE(3.00);

    private double price;

    // Constructor to set the price for each drink size
    DrinkSize(double price) {
        this.price = price;
    }

    // Get the price for a drink size
    public double getPrice() {
        return price;
    }
}
