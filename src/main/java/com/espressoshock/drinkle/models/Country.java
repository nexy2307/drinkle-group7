package com.espressoshock.drinkle.models;

public enum Country {
    //TODO ..MORE TO COME
    AUSTRIA("  ","Austria"), AUSTRALIA("","Australia"),
    ALGERIA("","Algeria");

    private final String countryCode;
    private final String countryName;

    Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
