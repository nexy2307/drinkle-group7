package com.espressoshock.drinkle.models.Drinkle;

import com.espressoshock.drinkle.models.Unit;

import java.math.BigDecimal;

public class Package {
    private double volume;
    private Unit unit;
    private BigDecimal price;

    public Package(double volume, Unit unit, BigDecimal price) {
        this.volume = volume;
        this.unit = unit;
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public Unit getUnit() {
        return unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
