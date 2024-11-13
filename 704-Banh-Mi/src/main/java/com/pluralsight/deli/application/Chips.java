package com.pluralsight.deli.application;

import com.pluralsight.deli.staff.MenuItem;

public class Chips extends MenuItem {
    // Constructor to initialize chips with a fixed price
    public Chips() {
        this.basePrice = 1.50; // Fixed price for chips
        this.name = "Chips";
    }

    // Method to get the price of chips
    @Override
    public double getPrice() {
        return basePrice; // Return the fixed price for chips
    }

    // Method to display the details of chips
    @Override
    public void displayDetails() {
        // Display chips details
        System.out.println("Chips");
        System.out.println("Price: $" + getPrice());
    }
}