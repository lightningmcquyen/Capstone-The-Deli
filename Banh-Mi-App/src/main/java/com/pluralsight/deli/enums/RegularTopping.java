package com.pluralsight.deli.enums;

public enum RegularTopping {
    LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS, PICKLED_CARROTS, CILANTRO;

    public double getPrice() {
        return 0; // Regular toppings are free
    }
}