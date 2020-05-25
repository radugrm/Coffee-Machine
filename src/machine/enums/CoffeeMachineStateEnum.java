package machine.enums;

import machine.CoffeeMachine;

public enum CoffeeMachineStateEnum {
    MAIN_MENU {
        @Override
        public void moveOn(CoffeeMachine coffeeMachine, String input) {
            coffeeMachine.processMainMenu(input);
        }
    },
    BUY_MENU {
        @Override
        public void moveOn(CoffeeMachine coffeeMachine, String input) {
            coffeeMachine.processBuyMenu(input);
        }
    },
    FILL_WATER_MENU {
        @Override
        public void moveOn(CoffeeMachine coffeeMachine, String input) {
            coffeeMachine.fillWater(input);
        }
    },
    FILL_MILK_MENU {
        @Override
        public void moveOn(CoffeeMachine coffeeMachine, String input) {
            coffeeMachine.fillMilk(input);
        }
    },
    FILL_COFFEE_BEANS_MENU {
        @Override
        public void moveOn(CoffeeMachine coffeeMachine, String input) {
            coffeeMachine.fillCoffeeBeans(input);
        }
    },
    FILL_DISPOSABLE_CUPS_MENU {
        @Override
        public void moveOn(CoffeeMachine coffeeMachine, String input) {
            coffeeMachine.fillDisposableCups(input);
        }
    };

    public abstract void moveOn(CoffeeMachine coffeeMachine, String input);
}
