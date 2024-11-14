package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.DrinkSize;  // Import the DrinkSize enum from the enums package

// Drink class implements OrderItem interface
public class Drink implements OrderItem {

    // Instance variables
    private DrinkSize size;  // The size of the drink (Small, Medium, Large)
    private double price;  // The price of the drink

    // Constructor which takes DrinkSize as input to initialize the size
    public Drink(DrinkSize size) {
        this.size = size;
        this.price = calculatePrice();  // Calculate the price based on the size of the drink
    }

    // Method to calculate the price based on the drink's size
    private double calculatePrice() {
        switch (size) {
            case SMALL:
                return 2.00;  // Price for Small size drink
            case MEDIUM:
                return 2.50;  // Price for Medium size drink
            case LARGE:
                return 3.00;  // Price for Large size drink
            default:
                return 0.00;  // Return 0 if an invalid size is provided
        }
    }

    // Implementing getPrice() method from OrderItem interface
    @Override
    public double getPrice() {
        return price;  // Return the calculated price
    }

    // Override the toString() method to display the drink's size and price
    @Override
    public String toString() {
        return "Drink: " + size + " - $" + price;  // Return a string representation of the drink
    }
}