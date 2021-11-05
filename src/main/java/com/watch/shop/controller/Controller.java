package com.watch.shop.controller;

import com.watch.shop.model.Clock;
import com.watch.shop.model.Model;
import com.watch.shop.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    Model model = new Model();
    View view = new View();
    int a;
        public void run () {
                view.exMenu();
                view.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                a = Integer.parseInt(reader.readLine());
//                if (a < 6) // потом проверить и исправить
//                System.out.println("Введено число больше 6");
//                return;
            } catch (IOException e) {
              //  e.printStackTrace();
                System.out.println("введённое значение не является числом");
            }
            switch (a){

                case 1:
                for (Clock clock : model.getModelClocks()) {
                view.displayClock(clock); }
                break;
                case 2:
                for (Clock clock : model.sortPrice()) {
                view.displayClock(clock); }
                break;
                case 3:
                for (Clock clock : model.sortColor()) {
                view.displayClock(clock); }
                break;
                case 4:
                for (Clock clock : model.sortDate()) {
                view.displayClock(clock); }
                break;
                case 5:
                System.out.println("Стоимость всех товаров " + model.sumPrice());
                break;
                case 6:
                view.sMenu();
                model.addGood();
                for (Clock clock : model.getModelClocks()) {
                view.displayClock(clock); }
                break;
            }




        }
}
