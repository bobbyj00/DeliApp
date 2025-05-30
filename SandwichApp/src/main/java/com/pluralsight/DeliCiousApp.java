package com.pluralsight;


import java.util.*;

public class DeliCiousApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to DELI-cious!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice == 1) handleOrder();
        }
    }

    private static void handleOrder() {
        Order order = new Order();
        while (true) {
            System.out.println("\nOrder Menu:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> order.addSandwich(createSandwich());
                case 2 -> order.addDrink(createDrink());
                case 3 -> order.addChips(createChips());
                case 4 -> {
                    System.out.println("\nORDER DETAILS:");
                    System.out.println(order.getOrderDetails());
                    System.out.print("Confirm order? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        ReceiptManager.saveReceipt(order);
                        System.out.println("Order saved. Returning to home screen.");
                        return;
                    }
                }
                case 0 -> {
                    System.out.println("Order canceled.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static Sandwich createSandwich() {
        System.out.println("Select sandwich size (4/8/12): ");
        int size = scanner.nextInt();
        scanner.nextLine();
        Size sandwichSize = switch (size) {
            case 4 -> Size.FOUR_INCH;
            case 8 -> Size.EIGHT_INCH;
            case 12 -> Size.TWELVE_INCH;
            default -> Size.EIGHT_INCH;
        };

        System.out.println("Select bread (white, wheat, rye, wrap): ");
        BreadType bread = BreadType.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Would you like it toasted? (y/n): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(sandwichSize, bread, toasted);

        System.out.println("Add meats (type 'done' when finished): ");
        while (true) {
            System.out.print("Meat: ");
            String meat = scanner.nextLine();
            if (meat.equalsIgnoreCase("done")) break;
            System.out.print("Extra? (y/n): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("y");
            sandwich.addMeat(new PremiumTopping(meat, ToppingType.MEAT, extra));
        }

        System.out.println("Add cheeses (type 'done' when finished): ");
        while (true) {
            System.out.print("Cheese: ");
            String cheese = scanner.nextLine();
            if (cheese.equalsIgnoreCase("done")) break;
            System.out.print("Extra? (y/n): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("y");
            sandwich.addCheese(new PremiumTopping(cheese, ToppingType.CHEESE, extra));
        }

        System.out.println("Add regular toppings (type 'done' when finished): ");
        while (true) {
            System.out.print("Topping: ");
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addRegularTopping(new RegularTopping(topping));
        }

        System.out.println("Add sauces (type 'done' when finished): ");
        while (true) {
            System.out.print("Sauce: ");
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("done")) break;
            sandwich.addSauce(sauce);
        }

        return sandwich;
    }

    private static Drink createDrink() {
        System.out.println("Select drink size (small, medium, large): ");
        DrinkSize size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    private static Chips createChips() {
        System.out.print("Enter chip type: ");
        return new Chips(scanner.nextLine());
    }
}

