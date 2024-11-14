package com.pluralsight.deli.enums;

public enum PremiumTopping {
    STEAK(1.00), HAM(1.00), SALAMI(1.00), ROAST_BEEF(1.00), CHICKEN(1.00), BACON(1.00), COLD_CUTS(1.00), GRILLED_PORK(1.00), PATE(1.00),
    EXTRA_MEAT(0.50), EXTRA_CHEESE(0.30);

    private double price;

    PremiumTopping(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}