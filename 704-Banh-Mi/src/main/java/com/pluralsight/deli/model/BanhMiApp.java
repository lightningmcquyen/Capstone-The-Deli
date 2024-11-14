package com.pluralsight.deli.model;

import com.pluralsight.deli.*;

public class BanhMiApp {

    public static void main(String[] args) {
        // Create an OrderProcessor instance to process the order
        OrderProcessor orderProcessor = new OrderProcessor();

        // Process the order
        orderProcessor.processOrder();
    }
}