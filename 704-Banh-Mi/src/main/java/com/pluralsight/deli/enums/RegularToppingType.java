package com.pluralsight.deli.enums;

// Enum representing different regular toppings for sandwiches
public enum RegularToppingType {
    LETTUCE(0.0), PEPPERS(0.0), ONIONS(0.0), TOMATOES(0.0),
    JALAPENOS(0.0), CUCUMBERS(0.0), PICKLES(0.0), GUACAMOLE(0.0),
    MUSHROOMS(0.0), CILANTRO(0.0), PICKLED_CARROTS(0.0), PATE (0.0), BUTTER(0.0);

    private double price;

    // Constructor to set the price for each topping
    RegularToppingType(double price) {
        this.price = price;
    }

    // Get the price for a topping
    public double getPrice() {
        return price;
    }
}

