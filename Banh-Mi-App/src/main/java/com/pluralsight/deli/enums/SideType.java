package com.pluralsight.deli.enums;

// Enum to represent the side options (au jus, homemade butter)
public enum SideType {
    AU_JUS, HOMEMADE_BUTTER;

    public double getPrice() {
        return 0; // Sides are free
    }
}