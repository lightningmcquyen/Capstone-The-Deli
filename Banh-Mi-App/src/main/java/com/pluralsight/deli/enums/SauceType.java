package com.pluralsight.deli.enums;

public enum SauceType {
    MAYO(0), MUSTARD(0), KETCHUP(0), RANCH(0), THOUSAND_ISLANDS(0), VINAIGRETTE(0);

    private double price;

    SauceType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}