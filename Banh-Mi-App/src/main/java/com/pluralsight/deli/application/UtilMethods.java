package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilMethods {

    private static final Scanner scanley = new Scanner(System.in);

    // Used a generic class - takes any enum classes as a parameter for less repetitive code
    public static <T extends Enum<T>> T promptForEnum(Class<T> enumClass) {
        // ANSI escape codes for blue and reset
        String blue = "\033[34m";
        String reset = "\033[0m";

        System.out.println(blue + """
    🥪 Select Option 🥪
    ====================
""" + reset);

        T[] enumConstants = enumClass.getEnumConstants(); // Gets values from enum class
        for (int i = 0; i < enumConstants.length; i++) { // (Initialize, conditional - stops at the length, inc/dec) - check length of how many constants in my enum class
            System.out.println((i + 1) + ") " + enumConstants[i]); // Fixes the index of options + enumConstants[i]
        }
        int choice = scanley.nextInt();
        return enumConstants[choice - 1]; // Returns enum value (-1 would make the 1st option 0)
    }


    public static <T extends Enum<T>> List<T> promptForEnumSelections(Class<T> enumClass) {
        List<T> selections = new ArrayList<>();
        // ANSI escape codes for blue and reset
        String blue = "\033[34m";
        String reset = "\033[0m";

        System.out.println(blue + """
           🥪 Select Options 🥪 
    ====================================
    You may choose more than one.
    Enter 0 to continue with your order.
    ====================================
    """ + reset);

        // Get the enum constants from the enum class passed as argument
        T[] enumConstants = enumClass.getEnumConstants();

        // Display the available enum constants with an index starting from 1
        for (int i = 0; i < enumConstants.length; i++) {
            System.out.println((i + 1) + ") " + enumConstants[i]); // Display each enum constant with a number
        }

        int choice;

        // Allow multiple selections
        do {
            choice = scanley.nextInt(); // Read the user's input (choice)

            // If the choice is within the valid range, add the corresponding enum constant to the list
            if (choice > 0 && choice <= enumConstants.length) {
                selections.add(enumConstants[choice - 1]);
            }

        } while (choice != 0); // Repeat until the user enters 0 to stop

        // Return the list of selected enum constants
        return selections;
    }

    // Prompt for drink size
    public static DrinkSize promptForDrinkSize() {
        System.out.println("Choose drink size: ");
        for (DrinkSize size : DrinkSize.values()) {
            System.out.println(size.ordinal() + 1 + ") " + size); // Returns the position of an enum constant in its declaration (i.e. its "index")
        }
        return DrinkSize.values()[scanley.nextInt() - 1]; // Returns an array containing all the constants of the enum in the order in which they were declared
    }


    public static String promptUserChoice (String prompt){
        System.out.println(prompt);
        return scanley.next();
    }

    public static String promptMaker (String prompt){
        System.out.println(prompt);
        return scanley.nextLine();
    }

    // Prompt if the user wants toasted sandwich
    public static boolean promptForToast() {
        System.out.print("Would you like your sandwich toasted? (yes/no): ");
        return scanley.next().equalsIgnoreCase("yes");
    }

    public static String promptForString(String message) {
        System.out.print(message);  // Display the message to prompt the user

        // Wait for the user's input and return it
        String input = scanley.nextLine();
        return input;
    }

    // Method to prompt the user to select a choice from a list of options
    public static int promptForChoice(int maxChoice) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please make a selection (0-" + maxChoice + "): ");
            String input = scanley.nextLine();  // Get input as a string

            // Try parsing the input into an integer
            try {
                choice = Integer.parseInt(input);

                // Check if the choice is within the valid range (0 to maxChoice)
                if (choice >= 0 && choice <= maxChoice) {
                    validInput = true;  // If valid, exit the loop
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and " + maxChoice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and " + maxChoice);
            }
        }
        return choice;
    }

    // New method to prompt for a Yes/No answer
    public static boolean promptForYesNo(String message) {
        System.out.print(message);
        String response = scanley.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}