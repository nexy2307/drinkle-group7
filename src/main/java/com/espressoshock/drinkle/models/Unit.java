package com.espressoshock.drinkle.models;

public enum Unit {
    GRAM("g"), MILLILITER("ml"), OUNCE("oz"), TEASPPON("ts"), COUNT("ct");

    private final String code;

    Unit(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
