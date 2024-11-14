package com.pluralsight.deli.model;

public class Chips implements OrderItem {

    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return flavor + " chips";
    }

    @Override
    public double getPrice() {
        return 1.50; // Fixed price for chips
    }
}