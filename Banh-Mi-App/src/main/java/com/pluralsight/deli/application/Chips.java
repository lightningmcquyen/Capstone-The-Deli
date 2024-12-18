package com.pluralsight.deli.application;

public class Chips implements Orderable {

    private String flavor;

    // Default constructor with a default flavor
    public Chips() {

        this.flavor = "Plain";  // Default flavor
    }


    public void setFlavor(String flavor) {

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

    @Override
    public String toString() {
        return "Chips: " + flavor;
    }

}