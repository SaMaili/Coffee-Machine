package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static final Scanner scanner = new Scanner(System.in);

    static MachineState currentState = MachineState.CHOOSING_ACTION;

    public static void main(String[] args) {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        while (true) {
            runAction(scanner.next());
        }
    }


    public static void showIngredients() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("\u0024" + money + " of money");
    }

    public static void buyCoffee(Coffee coffee) {
        CoffeeMachine.water -= coffee.getWater();
        CoffeeMachine.milk -= coffee.getMilk();
        CoffeeMachine.beans -= coffee.getCoffeeBeans();
        CoffeeMachine.money += coffee.getCost();
        cups--;
    }

    public static void refill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    public static void runAction(String command) {
        switch (currentState) {
            case CHOOSING_ACTION:
                switch (MachineState.getStateByCommand(command)) {
                    case BUYING_COFFEE:
                        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        currentState = MachineState.BUYING_COFFEE;
                        return;
                    case FILLING_INGREDIENTS:
                        refill();
                        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                        return;
                    case TAKING_MONEY:
                        System.out.println("\nI gave you \u0024" + money);
                        money = 0;
                        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                        return;
                    case CHECKING_REMAINING_INGREDIENTS:
                        showIngredients();
                        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                        return;
                    case EXITING:
                        System.exit(0);
                    default:
                        System.out.println("Unknown command. Try again.");
                        return;
                }
            case BUYING_COFFEE:
                Coffee selectedCoffee = Coffee.getCoffeeByShortcut(command);
                if (selectedCoffee.isSaleable() && selectedCoffee != Coffee.BACK) {
                    buyCoffee(selectedCoffee);
                }
                currentState = MachineState.CHOOSING_ACTION;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
        }
    }
}

enum MachineState {
    CHOOSING_ACTION("back"),
    BUYING_COFFEE("buy"),
    FILLING_INGREDIENTS("fill"),
    TAKING_MONEY("take"),
    CHECKING_REMAINING_INGREDIENTS("remaining"),
    EXITING("exit");

    final String command;

    MachineState(String name) {
        this.command = name;
    }

    public String getCommand() {
        return command;
    }

    public static MachineState getStateByCommand(String command) {
        for (MachineState state : MachineState.values()) {
            if (state.getCommand().equals(command)) {
                return state;
            }
        }
        return MachineState.CHOOSING_ACTION;
    }
}

enum Coffee {
    ESPRESSO("1", 250, 0, 16, 4),
    LATTE("2", 350, 75, 20, 7),
    CAPPUCCINO("3", 200, 100, 12, 6),
    BACK("back", 0, 0, 0, 0);

    String shortcut;
    int water;
    int milk;
    int coffeeBeans;
    int cost;

    Coffee(String shortcut, int water, int milk, int coffeeBeans, int cost) {
        this.shortcut = shortcut;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    public String getShortcut() {
        return shortcut;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCost() {
        return cost;
    }

    public boolean isSaleable() {
        if (CoffeeMachine.water - water < 0) {
            System.out.println("Sorry, not enough water!"); //water needed
            return false;
        } else if (CoffeeMachine.milk - milk < 0) {
            System.out.println("Sorry, not enough milk!"); //milk needed
            return false;
        } else if (CoffeeMachine.beans - coffeeBeans < 0) {
            System.out.println("Sorry, not enough coffee beans!"); //coffee beans needed
            return false;
        } else if (CoffeeMachine.cups - 1 < 0) {
            System.out.println("Sorry, im out of cups!"); //cups needed
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!"); //enough Ingredients
            return true;
        }
    }

    public static Coffee getCoffeeByShortcut(String shortcut) {
        for (Coffee coffee : Coffee.values()) {
            if (coffee.getShortcut().equals(shortcut)) {
                return coffee;
            }
        }
        return BACK;
    }
}

