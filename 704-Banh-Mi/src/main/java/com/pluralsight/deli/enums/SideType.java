package com.pluralsight.deli.enums;

// Enum representing different sides available
public enum SideType {
    AU_JUS(0.0), SAUCE(0.0); // Sides with no additional cost

    private double price;

    // Constructor to set the price for each side
    SideType(double price) {
        this.price = price;
    }

    // Get the price for a side
    public double getPrice() {
        return price;
    }
}