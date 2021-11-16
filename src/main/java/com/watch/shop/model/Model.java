package com.watch.shop.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    List<Clock> modelClocks = new ClockRepository().getClocksRepository();

    public List<Clock> getModelClocks() {
        return Collections.unmodifiableList(modelClocks);
    }

    public List<Clock> sortPrice() {
        return modelClocks.stream()
                .sorted(Comparator.comparing(Clock::getPrice).thenComparing(Clock::getPrice))
                .collect(Collectors.toList());
    }

    public List<Clock> sortColor() {
        return modelClocks.stream()
                .sorted(Comparator.comparing(Clock::getColor).thenComparing(Clock::getColor))
                .collect(Collectors.toList());
    }

    public List<Clock> sortDate() {
        return modelClocks.stream()
                .sorted(Comparator.comparing(Clock::getManufactureDate).thenComparing(Clock::getManufactureDate))
                .collect(Collectors.toList());
    }

    public BigDecimal sumPrice() {
        return modelClocks.stream()
                .map(Clock::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addClock(Clock clock) {
        modelClocks.add(clock);
    }
}
