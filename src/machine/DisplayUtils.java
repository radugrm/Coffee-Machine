package machine;

import machine.enums.CoffeeRecipeEnum;

public class DisplayUtils {
    public static void printCoffeeMachineStatus(int water, int milk, int coffeeBeans,
                                                int cups, int money) {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
    }

    public static void printMainMenuText() {
        System.out.print("Write action (buy, fill, take, remaining, exit):\n" +
                "> ");
    }

    public static void printBuyMenuText() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n" +
                "> ");
    }

    public static void printFillMenuWaterText() {
        System.out.print("Write how many ml of water do you want to add:\n" +
                "> ");
    }

    public static void printFillMenuMilkText() {
        System.out.print("Write how many ml of milk do you want to add:\n" +
                "> ");
    }

    public static void printFillMenuCoffeeBeansText() {
        System.out.print("Write how many grams of coffeeBeans do you want to add:\n" +
                "> ");
    }

    public static void printFillMenuDisposableCupsText() {
        System.out.print("Write how many disposable cups of coffee do you want to add:\n" +
                "> ");
    }

    public static boolean printMakeCoffeeErrorMessage(int water, int milk, int coffeeBeans, int cups,
                                                   CoffeeRecipeEnum recipeEnum) {
        if (water < recipeEnum.getWater()) {
            System.out.println("Sorry, not enough water!");
            return true;
        }
        if (milk < recipeEnum.getMilk()) {
            System.out.println( "Sorry, not enough milk!");
            return true;
        }
        if (coffeeBeans < recipeEnum.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return true;
        }
        if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return true;
        }
        return false;
    }

    public static void printMakeCoffeeSuccessMessage() {
        System.out.println("I have enough resources, making you a coffee!");
    }

    public static void printTakeMoneyText(int money) {
        System.out.println("I gave you $" + money);
    }

    public static void printIncorrectInputText() {
        System.out.print("Incorrect input. Please type one of the options displayed above\n" +
                "> ");
    }

    public static void printFillMenuError() {
        System.out.print("Incorrect input. Please enter a number \n" +
                "> ");
    }

    public static void printBuyCoffeeMenuError() {
        System.out.print("Enter the corresponding coffee number or \"back\"\n" +
                "> ");
    }
}
