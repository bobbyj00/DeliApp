package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double getTotalPrice() {
        return sandwiches.stream().mapToDouble(Sandwich::getPrice).sum()
                + drinks.stream().mapToDouble(Drink::getPrice).sum()
                + chips.stream().mapToDouble(Chips::getPrice).sum();
    }

    public String getOrderDetails() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Sandwich s : sandwiches) {
            sb.append("Sandwich ").append(count++).append(":\n").append(s.toString()).append("\n\n");
        }
        for (Drink d : drinks) {
            sb.append("Drink: ").append(d.toString()).append("\n");
        }
        for (Chips c : chips) {
            sb.append("Chips: ").append(c.toString()).append("\n");
        }
        sb.append("\nTotal: $").append(String.format("%.2f", getTotalPrice()));
        return sb.toString();
    }
}
