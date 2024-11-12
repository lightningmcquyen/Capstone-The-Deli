package com.pluralsight.deli.enums;

// Enum representing different sauces for sandwiches
public enum SauceType {
    MAYO(0.0), MUSTARD(0.0), KETCHUP(0.0), RANCH(0.0),
    THOUSAND_ISLANDS(0.0), VINAIGRETTE(0.0);

    private double price;

    // Constructor to set the price for each sauce
    SauceType(double price) {
        this.price = price;
    }

    // Get the price for a sauce
    public double getPrice() {
        return price;
    }
}

