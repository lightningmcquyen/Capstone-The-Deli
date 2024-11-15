package com.pluralsight.deli.application;

// Shared behavior amongst different types of products
public interface OrderItem {

    String getDescription();
    double getPrice();
}