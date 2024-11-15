package com.pluralsight.deli.enums;

public enum PremiumTopping {
    STEAK(1.00, 2.00, 3.00),
    HAM(1.00, 2.00, 3.00),
    SALAMI(1.00, 2.00, 3.00),
    ROAST_BEEF(1.00, 2.00, 3.00),
    CHICKEN(1.00, 2.00, 3.00),
    BACON(1.00, 2.00, 3.00),
    COLD_CUTS(1.00, 2.00, 3.00),
    GRILLED_PORK(1.00, 2.00, 3.00),
    PATE(1.00, 2.00, 3.00),
    AMERICAN(0.75, 1.50, 2.25),
    PROVOLONE(0.75, 1.50, 2.25),
    CHEDDAR(0.75, 1.50, 2.25),
    SWISS(0.75, 1.50, 2.25);

    private final double priceFor4Inch;
    private final double priceFor8Inch;
    private final double priceFor12Inch;

    PremiumTopping(double priceFor4Inch, double priceFor8Inch, double priceFor12Inch) {
        this.priceFor4Inch = priceFor4Inch;
        this.priceFor8Inch = priceFor8Inch;
        this.priceFor12Inch = priceFor12Inch;
    }

    // Get the price for the topping based on the sandwich size
    public double getPrice(SandwichSize size) {
        switch (size) {
            case FOUR_INCH:
                return priceFor4Inch;
            case EIGHT_INCH:
                return priceFor8Inch;
            case TWELVE_INCH:
                return priceFor12Inch;
            default:
                return 0;  // Default case in case something goes wrong (should not happen)
        }
    }
}