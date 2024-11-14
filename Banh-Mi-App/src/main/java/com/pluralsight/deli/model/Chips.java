package com.pluralsight.deli.model;

public class Chips implements OrderItem {  // Implement OrderItem if Chips is a type of OrderItem

    private double price = 1.50;

    // Default constructor
    public Chips() {
    }

    // Implement getPrice() if OrderItem interface requires it
    @Override
    public double getPrice() {
        return price;
    }

    // You may have a method like this if needed for chips-specific details
    @Override
    public String toString() {
        return "Chips - $1.50";  // Or any other details relevant to your chips
    }
}