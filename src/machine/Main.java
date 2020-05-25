package machine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.isOn()) {
            coffeeMachine.processInput(sc.next());
        }
    }
}
