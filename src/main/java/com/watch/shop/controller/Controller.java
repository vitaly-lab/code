package com.watch.shop.controller;

import com.watch.shop.model.Clock;
import com.watch.shop.model.Color;
import com.watch.shop.model.MechanismType;
import com.watch.shop.model.Model;
import com.watch.shop.view.InputHandler;
import com.watch.shop.view.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.watch.shop.view.Constants.CLOCK_MODEL;
import static com.watch.shop.view.Constants.ENTER_NUMBER;
import static com.watch.shop.view.Constants.ENTER_PRODUCT_DATA;
import static com.watch.shop.view.Constants.MAIN_MENU;
import static com.watch.shop.view.Constants.TOTAL_SUM;

public class Controller {
    private static final int EXIT_COMMAND = 7;

    private final Model model;
    private final View view;
    private final InputHandler inputHandler;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        inputHandler = new InputHandler();
    }

    public void run() {
        showMainMunu();
        showStartMessage();

        int command = readCommand();
        while (command != EXIT_COMMAND) {
            switch (command) {
                case 1:
                    showClocks(model.getModelClocks());
                    break;
                case 2:
                    showClocks(model.sortPrice());
                    break;
                case 3:
                    showClocks(model.sortColor());
                    break;
                case 4:
                    showClocks(model.sortDate());
                    break;
                case 5:
                    view.printMessage(TOTAL_SUM + model.sumPrice());
                    break;
                case 6:
                    showMenu();
                    addProduct();
                    showClocks(model.getModelClocks());
                    break;
            }
            showMainMunu();
            command = readCommand();
        }
    }

    private int readCommand() {
        return Integer.parseInt(inputHandler.readString());
    }

    private void showClocks(List<Clock> clockList) {
        clockList.forEach(this::displayClock);
    }

    private void displayClock(Clock clock) {
        view.printMessage(String.format(
                CLOCK_MODEL,
                clock.getName(),
                clock.getColor().toString(),
                clock.getPrice(),
                clock.getMechanismType().toString(),
                clock.getManufactureDate()));
    }

    private void showMainMunu() {
        view.printMessage(MAIN_MENU);
    }

    private void showStartMessage() {
        view.printMessage(ENTER_NUMBER);
    }

    private void showMenu() {
        view.printMessage(ENTER_PRODUCT_DATA);
    }

    private void addProduct() {
        List<String> inputLines = readLinesFromConsole();

        for (String line : inputLines) {
            model.addClock(buildClock(line));
        }
    }

    private List<String> readLinesFromConsole() {
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = inputHandler.readString();

            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }
        return lines;
    }

    private Clock buildClock(String inputData) {
        String[] clockAttributes = inputData.split(" ");
        String name = clockAttributes[0];
        Color color = Color.valueOf(clockAttributes[1].toUpperCase());
        MechanismType mechanismType = MechanismType.valueOf(clockAttributes[2].toUpperCase());
        BigDecimal price = new BigDecimal(clockAttributes[3]);
        String date = clockAttributes[4];

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate = LocalDate.parse(date, format);

        return new Clock(name, color, mechanismType, price, localDate);
    }
}

