package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.*;
import com.pluralsight.deli.enums.*;

import java.util.List;

public class SandwichScreen {

    // Display the Sandwich Screen where the user can choose a sandwich
    public static void displaySandwichScreen(Order order) {
        // ANSI escape code for blue
        String blue = "\033[34m";
        String reset = "\033[0m";  // ANSI code to reset to default color

        // Display the menu options in blue
        System.out.println(blue + """
            🥪 Choose a Sandwich 🥪
        ==========================
        1) Custom Sandwich
        2) BLT Signature Sandwich
        3) Philly Cheese Steak Signature Sandwich
        ==========================
        """ + reset);

        // Get the user's choice
        int choice = UtilMethods.promptForChoice(3);

        Sandwich sandwich = null;

        // Handle sandwich selection
        switch (choice) {
            case 1:
                sandwich = createCustomSandwich();
                break;
            case 2:
                sandwich = new SignatureBLT();  // Predefined BLT signature sandwich
                break;
            case 3:
                sandwich = new SignaturePhilly();  // Predefined Philly Cheese Steak sandwich
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
                return;  // Exit early if invalid input
        }

        // Add the selected sandwich to the order
        order.addItem(sandwich);
        System.out.println("Your sandwich has been added to the order.");

        // Allow customization of the selected sandwich (signature or custom)
        customizeSandwich(sandwich);

        // Proceed to the Order Screen after customization
        OrderScreen.displayOrderScreen(order);
    }

    // Create a custom sandwich
    private static Sandwich createCustomSandwich() {
        Sandwich sandwich = new Sandwich();  // Create a new empty sandwich

        // Prompt the user for their custom sandwich selections
        sandwich.setBread(UtilMethods.promptForEnum(BreadType.class));  // Prompt for bread type
        sandwich.setSize(UtilMethods.promptForEnum(SandwichSize.class));  // Prompt for size
        sandwich.setRegularToppings(UtilMethods.promptForEnumSelections(RegularTopping.class));  // Regular toppings
        sandwich.setPremiumToppings(UtilMethods.promptForEnumSelections(PremiumTopping.class));  // Premium toppings
        sandwich.setSauces(UtilMethods.promptForEnumSelections(SauceType.class));  // Sauces
        sandwich.setToasted(UtilMethods.promptForToast());  // Toasted or not

        return sandwich;
    }

    // Generic method for customizing any sandwich ingredient (toppings, sauces, etc.)
    private static <T extends Enum<T>> void customizeIngredient(String promptMessage, List<T> ingredientList, java.util.function.Consumer<List<T>> setterMethod) {
        System.out.println(promptMessage);
        boolean done = false;

        while (!done) {
            // ANSI escape code for blue
            String blue = "\033[34m";
            String reset = "\033[0m";  // ANSI code to reset to default color

            // Displaying the option to add/remove ingredients or finish customization
            System.out.println(blue + """
                   🥪 Customize Ingredients 🥪
                   ============================
                    1) Add Ingredients
                    2) Remove Ingredients
                    3) Done
                   ============================
                    """ + reset);

            int choice = UtilMethods.promptForChoice(3);

            switch (choice) {
                case 1:
                    setterMethod.accept(UtilMethods.promptForEnumSelections(ingredientList.get(0).getClass()));  // Add selected ingredients
                    break;
                case 2:
                    removeIngredient(ingredientList);  // Remove selected ingredient
                    break;
                case 3:
                    done = true;  // Finish customization
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Generic method to remove ingredients (regular toppings, premium toppings, sauces)
    private static <T extends Enum<T>> void removeIngredient(List<T> ingredientList) {
        if (!ingredientList.isEmpty()) {
            System.out.println("Choose an ingredient to remove: ");
            int count = 1;
            for (T ingredient : ingredientList) {
                System.out.println(count++ + ") " + ingredient);
            }
            int choice = UtilMethods.promptForChoice(ingredientList.size());
            ingredientList.remove(choice - 1);  // Remove the selected ingredient
            System.out.println("Ingredient removed.");
        } else {
            System.out.println("No ingredients to remove.");
        }
    }

    // Customize an existing sandwich (signature or custom)
    private static void customizeSandwich(Sandwich sandwich) {
        // Allow the user to customize the sandwich toppings, sauces, and toast setting
        System.out.println("Would you like to customize your sandwich?");
        boolean customizing = UtilMethods.promptForYesNo("Enter yes or no: ");

        if (customizing) {
            // Allow changes to the signature sandwich properties
            boolean done = false;
            while (!done) {
                // ANSI escape code for blue
                String blue = "\033[34m";
                String reset = "\033[0m";  // ANSI code to reset to default color

                // Displaying the options for customizing sandwich ingredients
                                System.out.println(blue + """
                🥪 What can I help you customize? 🥪
                =====================================
                1) Bread
                2) Regular Toppings
                3) Premium Toppings
                4) Sauces
                5) Toasted Setting
                6) Done Customizing
                =====================================
                """ + reset);

                int choice = UtilMethods.promptForChoice(6);  // User selects what to customize

                switch (choice) {
                    case 1:
                        sandwich.setBread(UtilMethods.promptForEnum(BreadType.class));  // Change bread type
                        break;
                    case 2:
                        customizeIngredient("Would you like to customize regular toppings?", sandwich.getRegularToppings(), sandwich::setRegularToppings);  // Customize regular toppings
                        break;
                    case 3:
                        customizeIngredient("Would you like to customize premium toppings?", sandwich.getPremiumToppings(), sandwich::setPremiumToppings);  // Customize premium toppings
                        break;
                    case 4:
                        customizeIngredient("Would you like to customize sauces?", sandwich.getSauces(), sandwich::setSauces);  // Customize sauces
                        break;
                    case 5:
                        boolean toastSetting = UtilMethods.promptForToast();  // Change toast setting
                        sandwich.setToasted(toastSetting);
                        break;
                    case 6:
                        done = true;  // Finish customization
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Your sandwich will proceed with the selected options.");
        }
    }

}