package machine;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int income;
    private ArrayList<CoffeeVarieties> coffeeVarieties;

    public Machine(int water, int milk, int beans, int cups, int income) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.income = income;
        fillCoffeeVarieties();
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getIncome() {
        return income;
    }

    protected void fillCoffeeVarieties() {
        coffeeVarieties = new ArrayList<CoffeeVarieties>();
        coffeeVarieties.add(new CoffeeVarieties(1, "espresso", 250, 0, 16, 4));
        coffeeVarieties.add(new CoffeeVarieties(2, "latte", 350, 75, 20, 7));
        coffeeVarieties.add(new CoffeeVarieties(3, "cappuccino", 200, 100, 12, 6));
    }

    public void actions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            try {
                if (action.equals("buy")) {
                    actionBuy();
                } else if (action.equals("fill")) {
                    actionFill();
                } else if (action.equals("take")) {
                    actionTake();
                } else if (action.equals("remaining")) {
                    actionRemaining();
                } else if (action.equals("exit")) {
                    break;
                } else {
                    throw new IllegalArgumentException("Unknown action!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    void actionBuy() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - return to main menu:");
            String number = scanner.nextLine();

            if (number.equals("back")) {
                return;
            }
            try {
                makeCoffee(Integer.parseInt(number));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a valid number.");
            }
        }
    }

    void actionFill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(scanner.nextLine());
    }

    void actionTake() {
        System.out.println("I gave you $" + income);
        income = 0;
    }

    private void makeCoffee(int number) {
        CoffeeVarieties receipt =
                coffeeVarieties
                        .stream()
                        .filter(n -> n.getNumber() == number)
                        .findFirst().orElseThrow(IllegalArgumentException::new);
        if (water < receipt.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < receipt.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < receipt.getBeans()) {
            System.out.println("Sorry, not enough beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= receipt.getWater();
            milk -= receipt.getMilk();
            beans -= receipt.getBeans();
            income += receipt.getPrice();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    void actionRemaining() {
        printInfoAboutCoffeeMachine();
    }

    public void printInfoAboutCoffeeMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + income + " of money\n");
    }


}
