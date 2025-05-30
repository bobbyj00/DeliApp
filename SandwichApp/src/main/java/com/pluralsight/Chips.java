package com.pluralsight;

class Chips {
    private String type;
    private final double price = 1.50;

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return type + " Chips ($" + price + ")";
    }
}
