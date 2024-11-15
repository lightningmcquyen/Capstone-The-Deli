package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Orderable {

    private BreadType bread;
    private SandwichSize size;
    private List<PremiumTopping> premiumToppings = new ArrayList<>();
    private List<RegularTopping> regularToppings = new ArrayList<>();
    private List<SauceType> sauces = new ArrayList<>();
    private boolean isToasted;

    // Default constructor
    public Sandwich() {
        this.premiumToppings = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }

    // Setters for the sandwich properties
    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setPremiumToppings(List<PremiumTopping> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }

    public void setRegularToppings(List<RegularTopping> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public void setSauces(List<SauceType> sauces) {
        this.sauces = sauces;
    }

    public boolean setToasted(boolean promptForToast) {return isToasted;}

    @Override
    public String getDescription() {
        return String.format("""
        %s %s sandwich with:
        - Premium toppings: %s
        - Regular toppings: %s
        - Sauces: %s
        - Toasted: %b
        """, size, bread, premiumToppings, regularToppings, sauces, isToasted);
    }

    @Override
    public String toString() {
        // Return a readable description of the sandwich
        return getDescription();
    }


    @Override
    public double getPrice() {
        double price = size.getPrice(); // Start with the base price of the sandwich size

        // Add prices for premium toppings (using the getPrice method on PremiumTopping)
        for (PremiumTopping topping : premiumToppings) {
            price += topping.getPrice(size); // Passing size to get the correct price
        }

        // Add prices for regular toppings (they are free, so no price addition needed)
        for (RegularTopping topping : regularToppings) {
            price += topping.getPrice();
        }

        // Add prices for sauces (also free)
        for (SauceType sauce : sauces) {
            price += sauce.getPrice();
        }

        return price;
    }

}