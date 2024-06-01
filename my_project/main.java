package machine;

import java.util.Scanner;

import static java.lang.System.in;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine(400, 540, 120, 9, 550);
        machine.actions();
    }

}
