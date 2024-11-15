package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.DrinkSize;

public class Drink implements OrderItem {

    private DrinkSize size;
    private String flavor;

    // Default constructor
    public Drink() {
        // Initialize with default values
        this.size = null; // or any other default size you prefer
        this.flavor = "Unknown"; // Default flavor
    }

//    // Parameterized constructor
//    public Drink(DrinkSize size, String flavor) {
//        this.size = size;
//        this.flavor = flavor;
//    }

//    public DrinkSize getSize() {
//
//        return size;
//    }

    public void setSize(DrinkSize size) {

        this.size = size;
    }

//    public String getFlavor() {
//
//        return flavor;
//    }

    public void setFlavor(String flavor) {

        this.flavor = flavor;
    }

    @Override
    public String getDescription() {

        return size + " " + flavor + " drink";
    }

    @Override
    public double getPrice() {

        return size.getPrice();
    }

    @Override
    public String toString() {
        return "Drink: " + size + " - " + flavor;
    }
}