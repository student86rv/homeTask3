package ua.epam.simpleGame;

import java.util.Scanner;

public class GameRunner {

    private static final String START_MESSAGE = "1=Rock, 2=Paper, 3=Scissors, 0=Quit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();

        boolean quit = false;
        while (!quit) {
            System.out.println(START_MESSAGE);
            int choice = scanner.nextInt();

            if (choice == 0) {
                quit = true;
                break;
            } else {
                gameLogic.run(choice);
                System.out.println(gameLogic.getResult());
                System.out.println();
            }
        }
    }
}
