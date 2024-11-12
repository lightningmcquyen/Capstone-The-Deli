package com.pluralsight.deli.staff;

public abstract class MenuItem {
    // Base price and name for each menu item
    protected double basePrice;
    protected String name;

    // Abstract method to get the price
    public abstract double getPrice();

    // Abstract method to display the details
    public abstract void displayDetails();
}

