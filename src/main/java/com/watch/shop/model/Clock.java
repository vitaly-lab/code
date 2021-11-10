package com.watch.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Clock {

    private final String name;
    private final String color;
    private final String systemWork;
    private final BigDecimal price;
    private final LocalDate localDate;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSystemWork() {
        return systemWork;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Clock(String name, String color, String systemWork, BigDecimal price, LocalDate localDate) {
        this.name = name;
        this.color = color;
        this.systemWork = systemWork;
        this.price = price;
        this.localDate = localDate;
    }
}
