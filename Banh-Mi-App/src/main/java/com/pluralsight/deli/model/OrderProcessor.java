package com.pluralsight.deli.model;

import com.pluralsight.deli.ui.*;
import com.pluralsight.deli.util.PromptMaker;
import com.pluralsight.deli.enums.*;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {

    // Process Sandwich Order
    public static Sandwich processSandwich() {
        // Prompt user to select the type of bread
        BreadType bread = PromptMaker.promptForBreadType();

        // Prompt user to select the sandwich size
        SandwichSize size = PromptMaker.promptForSandwichSize();

        // Create a new Sandwich based on the bread and size
        Sandwich sandwich = new Sandwich(bread, size);

        // Add premium toppings (meats, cheeses)
        List<PremiumTopping> premiumToppings = PromptMaker.promptForPremiumToppings();
        for (PremiumTopping topping : premiumToppings) {
            sandwich.addPremiumTopping(topping);
        }

        // Add regular toppings (lettuce, tomatoes, etc.)
        List<RegularTopping> regularToppings = PromptMaker.promptForRegularToppings();
        for (RegularTopping topping : regularToppings) {
            sandwich.addRegularTopping(topping);
        }

        // Add sauces
        List<SauceType> sauces = PromptMaker.promptForSauces();
        for (SauceType sauce : sauces) {
            sandwich.addSauce(sauce);
        }

        // Ask if the user wants the sandwich toasted
        boolean toasted = PromptMaker.promptForToast();
        sandwich.setToasted(toasted);

        return sandwich;
    }

    // Process Drink Order
    public static Drink processDrink() {
        // Prompt user to select drink size
        DrinkSize size = PromptMaker.promptForDrinkSize();

        // Prompt user to select a drink flavor
        String flavor = PromptMaker.promptForDrinkFlavor();

        // Create a new Drink object based on the size and flavor
        return new Drink(size, flavor);
    }

    // Process Chips Order
    public static Chips processChips() {
        // Prompt user to select chip flavor
        String flavor = PromptMaker.promptForChipsFlavor();

        // Return a new Chips object with the selected flavor
        return new Chips(flavor);
    }

    // Method to modify existing order
    public static void modifyOrder(Order order) {
        // Example of allowing user to modify sandwich, drinks, chips, etc.
        // Don't know how to go about this logic...
        System.out.println("You can modify your order here.");
    }

    // Print the receipt
    public static void processCheckout(Order order) {
        ReceiptHandler.printReceipt(order);
    }
}