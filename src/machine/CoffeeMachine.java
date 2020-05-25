package machine;

import machine.enums.CoffeeMachineStateEnum;
import machine.enums.CoffeeRecipeEnum;

import static machine.enums.CoffeeMachineStateEnum.*;
import static machine.DisplayUtils.*;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    private CoffeeMachineStateEnum state;
    private boolean isOn;


    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        cups = 9;
        money = 550;
        state = MAIN_MENU;
        printMainMenuText();
        isOn = true;
    }

    public void processInput(String input) {
        state.moveOn(this, input);
    }

    public void processMainMenu(String input) {
        switch (input) {
            case "exit":
                turnOff();
                break;
            case "buy":
                printBuyMenuText();
                state = BUY_MENU;
                break;
            case "fill":
                printFillMenuWaterText();
                state = FILL_WATER_MENU;
                break;
            case "remaining":
                printCoffeeMachineStatus(water, milk, coffeeBeans, cups, money);
                printMainMenuText();
                break;
            case "take":
                take();
                printMainMenuText();
                break;
            default:
                printIncorrectInputText();
        }
    }

    public void processBuyMenu(String input) {
        try {
            if (!"back".equalsIgnoreCase(input)) {
                int ordinal = Integer.parseInt(input) - 1;
                prepareCoffee(CoffeeRecipeEnum.values()[ordinal]);
            }
            state = MAIN_MENU;
            printMainMenuText();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            printBuyCoffeeMenuError();
        }
    }

    public void fillWater(String input) {
        try {
            water += Integer.parseInt(input);
            printFillMenuMilkText();
            state = FILL_MILK_MENU;
        } catch (NumberFormatException nfe) {
            printFillMenuError();
        }
    }

    public void fillMilk(String input) {
        try {
            milk += Integer.parseInt(input);
            printFillMenuCoffeeBeansText();
            state = FILL_COFFEE_BEANS_MENU;
        } catch (NumberFormatException nfe) {
            printFillMenuError();
        }
    }

    public void fillCoffeeBeans(String input) {
        try {
            coffeeBeans += Integer.parseInt(input);
            printFillMenuDisposableCupsText();
            state = FILL_DISPOSABLE_CUPS_MENU;
        } catch (NumberFormatException nfe) {
            printFillMenuError();
        }
    }

    public void fillDisposableCups(String input) {
        cups += Integer.parseInt(input);
        try {
            printMainMenuText();
            state = MAIN_MENU;
        } catch (NumberFormatException nfe) {
            printFillMenuError();
        }
    }

    public void prepareCoffee(CoffeeRecipeEnum recipeEnum) {
        if (printMakeCoffeeErrorMessage(water, milk, coffeeBeans, cups, recipeEnum)) {
            return;
        }
        water -= recipeEnum.getWater();
        milk -= recipeEnum.getMilk();
        coffeeBeans -= recipeEnum.getCoffeeBeans();
        money += recipeEnum.getPrice();
        cups--;
        printMakeCoffeeSuccessMessage();
    }

    public void take() {
        printTakeMoneyText(money);
        money = 0;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }
}
