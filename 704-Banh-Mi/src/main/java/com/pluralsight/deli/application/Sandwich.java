package com.pluralsight.deli.application;

// Import enums, packages, List, etc.
import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.MeatType;
import com.pluralsight.deli.enums.CheeseType;
import com.pluralsight.deli.enums.RegularToppingType;
import com.pluralsight.deli.staff.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItem {
    // Instance variables for sandwich
    private BreadType bread;
    private int size;
    private List<MeatType> meats;
    private List<CheeseType> cheeses;
    private List<RegularToppingType> toppings;
    private boolean toasted;

    // Constructor to initialize the sandwich
    public Sandwich(BreadType bread, int size) {
        this.bread = bread;
        this.size = size;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.toasted = false;
        this.basePrice = bread.getPriceForSize(size); // Set base price based on bread and size
    }

    // Add meat to the sandwich
    public void addMeat(MeatType meat) {
        meats.add(meat); // Add meat to the list
        basePrice += meat.getPriceForSize(size); // Add meat price based on sandwich size
    }

    // Add cheese to the sandwich
    public void addCheese(CheeseType cheese) {
        cheeses.add(cheese); // Add cheese to the list
        basePrice += cheese.getPriceForSize(size); // Add cheese price based on sandwich size
    }

    // Add toppings to the sandwich
    public void addTopping(RegularToppingType topping) {
        toppings.add(topping); // Add topping to the list
    }

    // Toast the sandwich
    public void toast() {
        this.toasted = true; // Set the sandwich to toasted
    }

    // Method to calculate the total price of the sandwich
    @Override
    public double getPrice() {
        return basePrice;
    }

    // Method to display the details of the sandwich
    @Override
    public void displayDetails() {
        // Show sandwich details including toppings, meats, etc.
        System.out.println("Sandwich: " + bread + " " + size + "\"");
        System.out.println("Meats: " + meats);
        System.out.println("Cheese: " + cheeses);
        System.out.println("Toppings: " + toppings);
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.println("Price: $" + getPrice());
    }
}