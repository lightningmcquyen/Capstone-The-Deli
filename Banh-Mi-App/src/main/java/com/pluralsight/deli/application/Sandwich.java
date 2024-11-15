package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderItem {

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

//    // Parameterized constructor
//    public Sandwich(BreadType bread, SandwichSize size) {
//        this.bread = bread;
//        this.size = size;
//        this.premiumToppings = new ArrayList<>();
//        this.regularToppings = new ArrayList<>();
//        this.sauces = new ArrayList<>();
//    }

//    // Add toppings, sauces, etc.
//    public void addPremiumTopping(PremiumTopping topping) {
//        premiumToppings.add(topping);
//    }
//
//    public void addRegularTopping(RegularTopping topping) {
//        regularToppings.add(topping);
//    }
//
//    public void addSauce(SauceType sauce) {
//        sauces.add(sauce);
//    }
//
//    public void setToasted(boolean toasted) {
//        this.toasted = toasted;
//    }
//
//    // Getters for the sandwich properties
//    public BreadType getBread() {
//        return bread;
//    }
//
//    public SandwichSize getSize() {
//        return size;
//    }
//
//    public List<PremiumTopping> getPremiumToppings() {
//        return premiumToppings;
//    }
//
//    public List<RegularTopping> getRegularToppings() {
//        return regularToppings;
//    }
//
//    public List<SauceType> getSauces() {
//        return sauces;
//    }
//
//    public boolean isToasted() {
//        return toasted;
//    }


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

    // Method from OrderItem interface
    @Override
    public String getDescription() {
        return size + " " + bread + " sandwich with premium toppings: " + premiumToppings + ", regular toppings: " + regularToppings + ", sauces: " + sauces + ", toasted: " + isToasted;
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

    public boolean setToasted(boolean promptForToast) {
        return isToasted;
    }
}