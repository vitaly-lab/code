package com.watch.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Clock {

    private final String name;
    private final Color color;
    private final MechanismType mechanismType;
    private final BigDecimal price;
    private final LocalDate manufactureDate;

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public MechanismType getMechanismType() {
        return mechanismType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Clock(String name, Color color, MechanismType mechanismType, BigDecimal price, LocalDate localDate) {
        this.name = name;
        this.color = color;
        this.mechanismType = mechanismType;
        this.price = price;
        this.manufactureDate = localDate;
    }
}
