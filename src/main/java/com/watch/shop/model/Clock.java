package com.watch.shop.model;

import java.time.LocalDate;

public class Clock {

    private String name;
    private String color;
    private String systemWork;
    private double price;
    private LocalDate localDate;

    public LocalDate getLocalDate() { return localDate; }

    public String getName() { return name; }
    public String getColor() { return color; }
    public String getSystemWork() { return systemWork; }
    public double getPrice() { return price; }

    public Clock(String name, String color, String systemWork, double price, LocalDate localDate) {
        this.name = name;
        this.color = color;
        this.systemWork = systemWork;
        this.price = price;
        this.localDate = localDate;
    }
}
