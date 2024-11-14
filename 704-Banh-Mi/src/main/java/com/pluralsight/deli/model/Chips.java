package com.pluralsight.deli.model;

public class Chips extends OrderItem {
    private double price = 1.50;
    private String name = "Chips";

    public Chips(Object item, double price) {
        super(item, price);
    }

    public Chips() {
        super();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}