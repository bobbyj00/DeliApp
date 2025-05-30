package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

class Sandwich {
    private Size size;
    private BreadType bread;
    private boolean toasted;
    private List<PremiumTopping> meats = new ArrayList<>();
    private List<PremiumTopping> cheeses = new ArrayList<>();
    private List<RegularTopping> regularToppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public Sandwich(Size size, BreadType bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public void addMeat(PremiumTopping meat) {
        meats.add(meat);
    }

    public void addCheese(PremiumTopping cheese) {
        cheeses.add(cheese);
    }

    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public double getPrice() {
        double price = switch (size) {
            case FOUR_INCH -> 5.50;
            case EIGHT_INCH -> 7.00;
            case TWELVE_INCH -> 8.50;
        };
        for (PremiumTopping meat : meats) {
            price += meat.getPrice(size);
        }
        for (PremiumTopping cheese : cheeses) {
            price += cheese.getPrice(size);
        }
        return price;
    }

    @Override
    public String toString() {
        return size + " sandwich on " + bread + " bread" + (toasted ? " (toasted)" : "") +
                "\nMeats: " + meats.stream().map(Topping::getName).toList() +
                "\nCheeses: " + cheeses.stream().map(Topping::getName).toList() +
                "\nToppings: " + regularToppings.stream().map(Topping::getName).toList() +
                "\nSauces: " + sauces;
    }
}