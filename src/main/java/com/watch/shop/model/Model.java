package com.watch.shop.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Model {

    List<Clock> modelClocks = new ArrayList<>();
    public List<Clock> getModelClocks() {
        return modelClocks;
    }

    {
        modelClocks.add(new Clock("Sony", "gold", "mehanic", 150.00, LocalDate.of(2021, 7, 28)));
        modelClocks.add(new Clock("Sony", "silver", "quartz", 11.00, LocalDate.of(2021, 3, 15)));
        modelClocks.add(new Clock("Sharp", "blue", "sun", 99.00, LocalDate.of(2021, 4, 16)));
        modelClocks.add(new Clock("Casio", "green", "quartz", 75.00, LocalDate.of(2021, 10, 12)));
        modelClocks.add(new Clock("Omega", "yellow", "arms", 210.00, LocalDate.of(2021, 1, 31)));
    }

    // 2. Приложение сортирует и выводит в консоль товаров по: цене
    public List <Clock> sortPrice () {
        return modelClocks.stream().sorted(Comparator.comparing(Clock::getPrice).thenComparing(Clock::getPrice)).collect(Collectors.toList());
    }
    // 3. Приложение сортирует и выводит в консоль товаров по: цвету
    public List<Clock> sortColor () {
        return modelClocks.stream().sorted(Comparator.comparing(Clock::getColor).thenComparing(Clock::getColor)).collect(Collectors.toList());
        }
    // 4. Приложение сортирует и выводит в консоль товаров по: дате поступления
    public List<Clock> sortDate () {
        return modelClocks.stream().sorted(Comparator.comparing(Clock::getLocalDate).thenComparing(Clock::getLocalDate)).collect(Collectors.toList());
    }
    // 5. Приложение показывает стоимость всех товаров
    public Double sumPrice (){
       double sum = modelClocks.stream().mapToDouble(Clock::getPrice).sum();
       return sum;
    }
    // 6. Приложение позволяет добавлять новые товары в магазин с консоли
     public void addGood () {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         ArrayList<String> list = new ArrayList<>();
         while (true) {
             String s = null;
             try {
                 s = reader.readLine();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             if (s.isEmpty()) break;
             list.add(s);
                }
                    for (String st : list) {

                        String[] subStr = st.split(" ");
                        String name = subStr[0];
                        String color = subStr[1];
                        String systemWork = subStr[2];
                        int price = Integer.parseInt(subStr[3]);
                        String date = subStr[4];

                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                    LocalDate localDate = LocalDate.parse(date, format);
                    modelClocks.add(new Clock(name, color, systemWork, price, localDate));
                    }
         }
     }

