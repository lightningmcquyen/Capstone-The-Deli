package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderItem {

    private BreadType bread;
    private SandwichSize size;
    private List<PremiumTopping> premiumToppings = new ArrayList<>();
    private List<RegularTopping> regularToppings = new ArrayList<>();
    private List<SauceType> sauces = new ArrayList<>();
    private boolean toasted;

    public Sandwich(BreadType bread, SandwichSize size) {
        this.bread = bread;
        this.size = size;
    }

    public void addPremiumTopping(PremiumTopping topping) {
        premiumToppings.add(topping);
    }

    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addSauce(SauceType sauce) {
        sauces.add(sauce);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public String getDescription() {
        return size + " " + bread + " sandwich with premium toppings: " + premiumToppings + ", regular toppings: " + regularToppings + ", sauces: " + sauces + ", toasted: " + toasted;
    }

    @Override
    public double getPrice() {
        double price = size.getPrice();
        for (PremiumTopping topping : premiumToppings) {
            price += topping.getPrice();
        }
        for (RegularTopping topping : regularToppings) {
            price += topping.getPrice();
        }
        for (SauceType sauce : sauces) {
            price += sauce.getPrice();
        }
        return price;
    }
}