package com.pluralsight;

class RegularTopping implements Topping {
    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
