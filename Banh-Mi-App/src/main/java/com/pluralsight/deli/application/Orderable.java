package com.pluralsight.deli.application;

// Shared behavior amongst different types of products
public interface Orderable {

    String getDescription();
    double getPrice();

}