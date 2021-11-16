package com.watch.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClockRepository {
    private List<Clock> clocks = new ArrayList<>();

    {
        clocks.add(new Clock("Sony", Color.GOLD, MechanismType.MECHANICAL, BigDecimal.valueOf(150.00), LocalDate.of(2021, 7, 28)));
        clocks.add(new Clock("Sony", Color.SILVER, MechanismType.QUARTZ, BigDecimal.valueOf(11.00), LocalDate.of(2021, 3, 15)));
        clocks.add(new Clock("Sharp", Color.BLUE, MechanismType.MECHANICAL, BigDecimal.valueOf(99.00), LocalDate.of(2021, 4, 16)));
        clocks.add(new Clock("Casio", Color.GREEN, MechanismType.QUARTZ, BigDecimal.valueOf(75.00), LocalDate.of(2021, 10, 12)));
        clocks.add(new Clock("Omega", Color.YELLOW, MechanismType.ELECTRONIC, BigDecimal.valueOf(210.00), LocalDate.of(2021, 1, 31)));
    }

    public List<Clock> getClocksRepository() {
        return clocks;
    }
}
