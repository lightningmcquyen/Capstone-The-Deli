package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.DrinkSize;
import com.pluralsight.deli.model.OrderItem;

public class Drink extends OrderItem {
    private DrinkSize size;
    private double price;

    public Drink(DrinkSize size) {
        this.size = size;
        // Assigning price based on the drink size
        switch (size) {
            case SMALL:
                this.price = 2.00;
                break;
            case MEDIUM:
                this.price = 2.50;
                break;
            case LARGE:
                this.price = 3.00;
                break;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return "Drink (" + size + ")";
    }
}