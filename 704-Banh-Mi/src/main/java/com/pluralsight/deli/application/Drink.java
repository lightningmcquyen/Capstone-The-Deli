package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.DrinkSize;
import com.pluralsight.deli.staff.MenuItem;


public class Drink extends MenuItem {
    private DrinkSize size;

    // Constructor to initialize the drink with a size
    public Drink(DrinkSize size) {
        this.size = size;
        this.basePrice = size.getPrice(); // Set base price based on drink size
    }

    // Method to get the price of the drink
    @Override
    public double getPrice() {
        return basePrice; // Return the price based on size
    }

    // Method to display the details of the drink
    @Override
    public void displayDetails() {
        // Display drink details
        System.out.println("Drink: " + size);
        System.out.println("Price: $" + getPrice());
    }
}