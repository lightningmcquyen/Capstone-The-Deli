package com.pluralsight.deli.enums;

// Enum representing different meat types for sandwiches
public enum MeatType {
    STEAK(1.00), HAM(1.00), SALAMI(1.00), ROAST_BEEF(1.00), CHICKEN(1.00), BACON(1.00), MISC_COLD_CUTS(1.00), GRILLED_PORK(2.00);

    private double price;

    // Constructor to set the price for each meat type
    MeatType(double price) {
        this.price = price;
    }

    // Get the price based on sandwich size
    public double getPriceForSize(int size) {
        if (size == 8) return price + 1.00;  // Additional price for 8-inch sandwich
        if (size == 12) return price + 2.00; // Additional price for 12-inch sandwich
        return price; // Default price for 4-inch sandwich
    }
}

