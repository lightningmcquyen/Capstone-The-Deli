package com.pluralsight.deli.enums;

public enum SauceType {
    MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE, AU_JUS, HOMEMADE_BUTTER;

    private double price;

    public double getPrice() {
        return 0; // sauces are free
    }
}