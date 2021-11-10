package com.watch.shop;

import com.watch.shop.controller.Controller;
import com.watch.shop.model.Model;
import com.watch.shop.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);
        controller.run();
    }
}
