package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.DrinkSize;

public class Drink implements OrderItem {

    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
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
}