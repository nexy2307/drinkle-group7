package com.espressoshock.drinkle.models.Drinkle;


import com.espressoshock.drinkle.models.IAction.ICategory;

public enum IngredientCategory implements ICategory {
    //***** MORE TO COME
    GLASSWARE("Glassware"), GARNISH("Garnish"), ICE_TYPE("Ice Type");

    private final String displayName;

    IngredientCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return displayName;
    }
}
