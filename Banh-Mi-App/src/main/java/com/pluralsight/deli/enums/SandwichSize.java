package com.pluralsight.deli.enums;

public enum SandwichSize {
    FOUR_INCH(5.50), EIGHT_INCH(7.00), TWELVE_INCH(8.50);

    private double price;

    SandwichSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}