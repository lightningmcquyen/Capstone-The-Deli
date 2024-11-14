package com.pluralsight.deli.util;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PromptMaker {

    private static final Scanner scanner = new Scanner(System.in);

    // Prompt for customer name
    public static String promptForCustomerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    // Prompt for sandwich size
    public static SandwichSize promptForSandwichSize() {
        System.out.println("Choose sandwich size: ");
        for (SandwichSize size : SandwichSize.values()) {
            System.out.println(size.ordinal() + 1 + ") " + size);
        }
        return SandwichSize.values()[scanner.nextInt() - 1];
    }

    // Prompt for bread type
    public static BreadType promptForBreadType() {
        System.out.println("Choose bread type: ");
        for (BreadType type : BreadType.values()) {
            System.out.println(type.ordinal() + 1 + ") " + type);
        }
        return BreadType.values()[scanner.nextInt() - 1];
    }

    // Prompt for regular toppings
    public static List<RegularTopping> promptForRegularToppings() {
        List<RegularTopping> toppings = new ArrayList<>();
        System.out.println("Select regular toppings (0 to stop): ");
        for (RegularTopping topping : RegularTopping.values()) {
            System.out.println(topping.ordinal() + 1 + ") " + topping);
        }

        int choice;
        do {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= RegularTopping.values().length) {
                toppings.add(RegularTopping.values()[choice - 1]);
            }
        } while (choice != 0);

        return toppings;
    }

    // Prompt for premium toppings
    public static List<PremiumTopping> promptForPremiumToppings() {
        List<PremiumTopping> toppings = new ArrayList<>();
        System.out.println("Select premium toppings (0 to stop): ");
        for (PremiumTopping topping : PremiumTopping.values()) {
            System.out.println(topping.ordinal() + 1 + ") " + topping);
        }

        int choice;
        do {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= PremiumTopping.values().length) {
                toppings.add(PremiumTopping.values()[choice - 1]);
            }
        } while (choice != 0);

        return toppings;
    }

    // Prompt for sauces
    public static List<SauceType> promptForSauces() {
        List<SauceType> sauces = new ArrayList<>();
        System.out.println("Select sauces (0 to stop): ");
        for (SauceType sauce : SauceType.values()) {
            System.out.println(sauce.ordinal() + 1 + ") " + sauce);
        }

        int choice;
        do {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= SauceType.values().length) {
                sauces.add(SauceType.values()[choice - 1]);
            }
        } while (choice != 0);

        return sauces;
    }

    // Prompt for drink size
    public static DrinkSize promptForDrinkSize() {
        System.out.println("Choose drink size: ");
        for (DrinkSize size : DrinkSize.values()) {
            System.out.println(size.ordinal() + 1 + ") " + size);
        }
        return DrinkSize.values()[scanner.nextInt() - 1];
    }

    // Prompt for drink flavor
    public static String promptForDrinkFlavor() {
        System.out.print("Enter drink flavor: ");
        return scanner.next();
    }

    // Prompt for chips flavor
    public static String promptForChipsFlavor() {
        System.out.print("Enter chips flavor: ");
        return scanner.next();
    }

    // Prompt if the user wants toasted sandwich
    public static boolean promptForToast() {
        System.out.print("Would you like your sandwich toasted? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }

    // Method to prompt the user to select a choice from a list of options
    public static int promptForChoice(int maxChoice) {
        int choice;
        do {
            System.out.print("Please make a selection (1-" + maxChoice + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice);
                scanner.next(); // Consume invalid input
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > maxChoice); // Ensure the choice is within the valid range
        return choice;
    }
}