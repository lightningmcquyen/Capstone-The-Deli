package com.pluralsight.deli.application;

import com.pluralsight.deli.enums.*;
import java.util.List;

public class SignaturePhilly extends Sandwich {

    public SignaturePhilly() {
        // Set the default values for this sandwich
        setBread(BreadType.WHITE);  // 8" white bread
        setSize(SandwichSize.EIGHT_INCH);
        setPremiumToppings(List.of(PremiumTopping.STEAK, PremiumTopping.AMERICAN));
        setRegularToppings(List.of(RegularTopping.PEPPERS));
        setSauces(List.of(SauceType.MAYO));
        setToasted(true);  // Toasted
    }
}