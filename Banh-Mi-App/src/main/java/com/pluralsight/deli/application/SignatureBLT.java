package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.*;
import java.util.List;

public class SignatureBLT extends Sandwich {

    public SignatureBLT() {
        // Set the default values for this sandwich
        setBread(BreadType.WHITE);  // 8" white bread
        setSize(SandwichSize.EIGHT_INCH);
        setPremiumToppings(List.of(PremiumTopping.BACON, PremiumTopping.CHEDDAR));
        setRegularToppings(List.of(RegularTopping.LETTUCE, RegularTopping.TOMATOES));
        setSauces(List.of(SauceType.RANCH));
        setToasted(true);  // Toasted
    }
}