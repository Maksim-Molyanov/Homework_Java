// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.

// Создать множество ноутбуков.

// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:

// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package ITOG;

import java.util.*;

public class Itog {  

    public static class Laptop {
        private String brand;
        private String model;
        private int ram;
        private int storage;
        private String os;
        private String color;
        private double price;

        public Laptop(String brand, String model, int ram, int storage,
        String os, String color, double price) {
            this.brand = brand;
            this.model = model;
            this.ram = ram;
            this.storage = storage;
            this.os = os;
            this.color = color;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getRam() {
            return ram;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }

        public int getStorage() {
            return storage;
        }

        public void setStorage(int storage) {
            this.storage = storage;
        }

        public String getOS() {
            return os;
        }

        public void setOS(String os) {
            this.os = os;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Ram: " + ram);
            System.out.println("Storage: " + storage);
            System.out.println("OS: " + os);
            System.out.println("Color: " + color);
            System.out.println("Price: " + price);
            System.out.println();
        }
    }
   
    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Xiaomi", "Redmi2022 15.5", 16, 512, "Ubuntu 22.04", "Silver", 69999.99));
        laptops.add(new Laptop("Xiaomi", "Redmi2022 14", 8, 250, "MS-DOS", "Black", 35555.59));
        laptops.add(new Laptop("Apple", "MacBook Pro", 16, 512, "macOS", "Gold", 120000.20));
        laptops.add(new Laptop("ASUS", "Tuf", 8, 512, "Windows 11", "black", 96000.00));

        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите цифру критерия:\n1 - ОЗУ\n2 - Объём ЖД\n3 - ОС\n4 - Цвет");
        String filterCriteria = scaner.nextLine();

        System.out.println("Введите минимальное значение для указанного критерия " + filterCriteria + ":");
        String filterValue = scaner.nextLine();       
        scaner.close();

        HashMap<String, String> filters = new HashMap<>();
        filters.put(getFilterField(filterCriteria), filterValue);

        List<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найденые ноутбуки:");
            filteredLaptops.forEach(Laptop::printInfo);
        }
        
    }

    private static String getFilterField(String filterCriteria) {
        switch (filterCriteria) {
            case "1":
                return "ram";
            case "2":
                return "storage";
            case "3":
                return "os";
            case "4":
                return "color";
            default:
                throw new IllegalArgumentException("Неверный критерий фильтрации");
        }
    }


    public static List<Laptop> filterLaptops(List<Laptop> laptops, HashMap<String, String> filters) {
       
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean FilterOK = false;

            for (String filterField : filters.keySet()) {               
                String filterValue = filters.get(filterField).toLowerCase();

                switch (filterField) {
                    case "ram":
                        if (laptop.getRam() >= Integer.parseInt(filterValue)) {
                            FilterOK = true;
                        }
                        break;
                    case "storage":
                        if (laptop.getStorage() >= Integer.parseInt(filterValue)) {
                            FilterOK = true;
                        }
                        break;
                    case "os":
                        if (laptop.getOS().toLowerCase().equals(filterValue)) {
                            FilterOK = true;
                        }
                        break;
                    case "color":
                        if (laptop.getColor().toLowerCase().equals(filterValue)) {
                            FilterOK = true;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный критерий: " + filterField);
                }
            }

            if (FilterOK) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }     
}