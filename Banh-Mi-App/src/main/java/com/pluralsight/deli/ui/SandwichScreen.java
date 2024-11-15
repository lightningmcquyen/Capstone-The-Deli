package com.pluralsight.deli.ui;

import com.pluralsight.deli.application.Order;
import com.pluralsight.deli.application.Sandwich;
import com.pluralsight.deli.application.UtilMethods;
import com.pluralsight.deli.enums.*;

public class SandwichScreen {

    public static void displaySandwichScreen(Order order) {
        // Create a new Sandwich object
        Sandwich sandwich = new Sandwich();

        // Prompt the user for sandwich options (bread type, size, toppings, sauces, toast preference)
//        sandwich.setBread(UtilMethods.promptForBreadType());
        sandwich.setBread(UtilMethods.promptForEnum(BreadType.class));
        sandwich.setSize(UtilMethods.promptForEnum(SandwichSize.class));
        sandwich.setRegularToppings(UtilMethods.promptForEnumSelections(RegularTopping.class));
        sandwich.setPremiumToppings(UtilMethods.promptForEnumSelections(PremiumTopping.class));
        sandwich.setSauces(UtilMethods.promptForEnumSelections(SauceType.class));
        sandwich.setToasted(UtilMethods.promptForToast());

        // Add the sandwich to the order
        order.addItem(sandwich);

        // Confirm addition to the user
        System.out.println("Your sandwich has been added to the order.");

        // Return to the Order Screen after the sandwich is added
        OrderScreen.displayOrderScreen(order);
    }
}