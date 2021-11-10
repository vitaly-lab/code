package com.watch.shop.view;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.next();
    }
}
