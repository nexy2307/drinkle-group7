package com.espressoshock.drinkle.models;

import jdk.jfr.Category;

public enum BeverageCategory implements ICategory {
    //***** MORE TO COME
    NON_ALCOHOLIC("Alcohol-free"),
    CLASSIC("Contemporary Classic"),
    HOT("Hot drinks"), FROZEN("Frozen drinks");

    private final String displayName;

    BeverageCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return displayName;
    }
}
