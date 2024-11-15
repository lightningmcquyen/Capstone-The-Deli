package com.pluralsight.deli.enums;

// Constant values = enums
public enum BreadType {
    WHITE(5.50), WHEAT(5.50), RYE(5.50), WRAP(5.50), BAGUETTE(5.50);

    private double price;

    BreadType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}