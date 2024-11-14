package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.*;

import java.util.List;

public class Sandwich implements OrderItem {

    private BreadType breadType;
    private SandwichSize size;
    private List<MeatType> meats;
    private List<PremiumTopping> premiumToppings;
    private SauceType sauce;
    private SideType side;

    public Sandwich(BreadType breadType, SandwichSize size, List<MeatType> meats,
                    List<PremiumTopping> premiumToppings, SauceType sauce, SideType side) {
        this.breadType = breadType;
        this.size = size;
        this.meats = meats;
        this.premiumToppings = premiumToppings;
        this.sauce = sauce;
        this.side = side;
    }

    @Override
    public double getPrice() {
        double price = 0;

        // Add price based on the size of the sandwich
        switch (size) {
            case FOUR_INCH:
                price = 5.50;
                break;
            case EIGHT_INCH:
                price = 7.00;
                break;
            case TWELVE_INCH:
                price = 8.50;
                break;
        }

        // Add price for meats
        for (MeatType meat : meats) {
            switch (size) {
                case FOUR_INCH:
                    price += 1.00;
                    break;
                case EIGHT_INCH:
                    price += 2.00;
                    break;
                case TWELVE_INCH:
                    price += 3.00;
                    break;
            }
        }

        // Add price for premium toppings
        for (PremiumTopping topping : premiumToppings) {
            switch (size) {
                case FOUR_INCH:
                    price += 0.50;
                    break;
                case EIGHT_INCH:
                    price += 1.00;
                    break;
                case TWELVE_INCH:
                    price += 1.50;
                    break;
            }
        }

        return price;
    }
}