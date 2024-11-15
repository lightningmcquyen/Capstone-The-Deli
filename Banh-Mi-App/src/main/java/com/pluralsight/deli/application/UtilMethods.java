package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilMethods {

    private static final Scanner scanley = new Scanner(System.in);

//    // Prompt for customer name
//    public static String promptForCustomerName() {
//        System.out.print("Enter your name: ");
//        return scanley.nextLine();
//    }


    // Used a generic class - takes any enum classes as a parameter for less repetitive code
    public static <T extends Enum<T>> T promptForEnum(Class<T> enumClass) {
        System.out.println("Choose an option: ");
        T[] enumConstants = enumClass.getEnumConstants(); // Gets values from enum class
        for (int i = 0; i < enumConstants.length; i++) { // (Initialize, conditional - stops at the length, inc/dec) - check length of how many constants in my enum class
            System.out.println((i + 1) + ") " + enumConstants[i]); // Fixes the index of options + enumConstants[i]
        }
        int choice = scanley.nextInt();
        return enumConstants[choice - 1]; // Returns enum value (-1 would make the 1st option 0)
    }


    public static <T extends Enum<T>> List<T> promptForEnumSelections(Class<T> enumClass) {
        List<T> selections = new ArrayList<>();
        System.out.println("Select options (0 to stop): ");

        T[] enumConstants = enumClass.getEnumConstants();

        // Display the available enum constants
        for (int i = 0; i < enumConstants.length; i++) {
            System.out.println((i + 1) + ") " + enumConstants[i]);
        }

        int choice;
        do {
            choice = scanley.nextInt();
            if (choice > 0 && choice <= enumConstants.length) {
                selections.add(enumConstants[choice - 1]);
            }
        } while (choice != 0);

        return selections;
    }

    // Prompt for drink size
    public static DrinkSize promptForDrinkSize() {
        System.out.println("Choose drink size: ");
        for (DrinkSize size : DrinkSize.values()) {
            System.out.println(size.ordinal() + 1 + ") " + size);
        }
        return DrinkSize.values()[scanley.nextInt() - 1];
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
        scanley.nextLine();  // Ensure no leftover newline character from previous input

        // Wait for the user's input and return it
        String input = scanley.nextLine();
        return input;
    }

    // Method to prompt the user to select a choice from a list of options
    public static int promptForChoice(int maxChoice) {
        int choice;
        do {
            System.out.print("Please make a selection (0-" + maxChoice + "): ");
            while (!scanley.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and " + maxChoice);
                scanley.next(); // Consume invalid input
            }
            choice = scanley.nextInt();
        } while (choice < 1 || choice > maxChoice); // Ensure the choice is within the valid range
        return choice;
    }

    // New method to prompt for a Yes/No answer
    public static boolean promptForYesNo(String message) {
        System.out.print(message);
        String response = scanley.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}