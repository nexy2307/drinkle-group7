package com.espressoshock.drinkle.models.Drinkle;

public class Brand {
    private String name;
    private String description;
    private String brandColor;

    public Brand(String name, String description, String brandColor) {
        this.name = name;
        this.description = description;
        this.brandColor = brandColor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrandColor() {
        return brandColor;
    }

}
