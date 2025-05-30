package com.pluralsight;

class PremiumTopping implements Topping {
    private String name;
    private ToppingType type;
    private boolean extra;

    public PremiumTopping(String name, ToppingType type, boolean extra) {
        this.name = name;
        this.type = type;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice(Size size) {
        double basePrice = 0;
        switch (type) {
            case MEAT:
                basePrice = switch (size) {
                    case FOUR_INCH -> 1.00;
                    case EIGHT_INCH -> 2.00;
                    case TWELVE_INCH -> 3.00;
                };
                if (extra) {
                    basePrice += switch (size) {
                        case FOUR_INCH -> 0.50;
                        case EIGHT_INCH -> 1.00;
                        case TWELVE_INCH -> 1.50;
                    };
                }
                break;
            case CHEESE:
                basePrice = switch (size) {
                    case FOUR_INCH -> 0.75;
                    case EIGHT_INCH -> 1.50;
                    case TWELVE_INCH -> 2.25;
                };
                if (extra) {
                    basePrice += switch (size) {
                        case FOUR_INCH -> 0.30;
                        case EIGHT_INCH -> 0.60;
                        case TWELVE_INCH -> 0.90;
                    };
                }
                break;
        }
        return basePrice;
    }
}