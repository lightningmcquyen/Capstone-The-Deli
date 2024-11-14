package com.pluralsight.deli.util;

import com.pluralsight.deli.model.*;
import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PromptMaker {

    private static final Scanner scanner = new Scanner(System.in);

    // Prompt the user to enter their name
    public static String promptForCustomerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    // Prompt the user to create a sandwich
    public static Sandwich promptForSandwich() {
        // Prompt for bread type
        System.out.println("Select Bread Type (1: White, 2: Wheat, 3: Rye, 4: Wrap, 5: Baguette): ");
        int breadChoice = Integer.parseInt(scanner.nextLine());
        BreadType breadType = BreadType.values()[breadChoice - 1];

        // Prompt for sandwich size
        System.out.println("Select Sandwich Size (1: 4\", 2: 8\", 3: 12\"): ");
        int sizeChoice = Integer.parseInt(scanner.nextLine());
        SandwichSize size = SandwichSize.values()[sizeChoice - 1];

        // Prompt for premium meats
        List<MeatType> meats = new ArrayList<>();
        System.out.println("Select Meats (1: Steak, 2: Ham, 3: Salami, 4: Roast Beef, 5: Chicken, 6: Bacon, 7: Cold Cuts, 8: Grilled Pork, 9: Pate): ");
        String meatChoice = scanner.nextLine();
        for (String choice : meatChoice.split(",")) {
            meats.add(MeatType.values()[Integer.parseInt(choice.trim()) - 1]);
        }

        // Prompt for premium toppings
        List<PremiumTopping> premiumToppings = new ArrayList<>();
        System.out.println("Select Premium Toppings (1: Cheese, 2: Extra Cheese): ");
        String toppingChoice = scanner.nextLine();
        for (String choice : toppingChoice.split(",")) {
            premiumToppings.add(PremiumTopping.values()[Integer.parseInt(choice.trim()) - 1]);
        }

        // Prompt for sauce selection
        System.out.println("Select Sauce (1: Mayo, 2: Mustard, 3: Ketchup, 4: Ranch, 5: Thousand Islands, 6: Vinaigrette): ");
        int sauceChoice = Integer.parseInt(scanner.nextLine());
        SauceType sauce = SauceType.values()[sauceChoice - 1];

        // Prompt for side selection
        System.out.println("Select Side (1: Au Jus, 2: Homemade Butter): ");
        int sideChoice = Integer.parseInt(scanner.nextLine());
        SideType side = SideType.values()[sideChoice - 1];

        // Create and return the Sandwich object with the user choices
        return new Sandwich(breadType, size, meats, premiumToppings, sauce, side);
    }

    // Prompt the user to add a drink to the order
    public static boolean promptForAddDrink() {
        System.out.print("Would you like to add a drink? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }

    // Prompt the user for drink size and type
    // Method to prompt the user for a drink selection
    public static Drink promptForDrink() {
        // Prompt the user for drink size
        System.out.println("Select Drink Size (1: Small, 2: Medium, 3: Large): ");
        int sizeChoice = Integer.parseInt(scanner.nextLine());

        // Get the DrinkSize from the enum based on user choice
        DrinkSize size = DrinkSize.values()[sizeChoice - 1];  // DrinkSize.SMALL, DrinkSize.MEDIUM, or DrinkSize.LARGE

        // Create and return the Drink object with the selected size
        return new Drink(size);
    }


    // Prompt the user to add chips to the order
    public static boolean promptForAddChips() {
        System.out.print("Would you like to add chips? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }

    // Prompt the user to choose chips type (for simplicity, we can just have one type for now)
    public static Chips promptForChips() {
        System.out.println("Select Chips Type (1: Regular Chips): ");
        int chipChoice = Integer.parseInt(scanner.nextLine());
        return new Chips();
    }
}