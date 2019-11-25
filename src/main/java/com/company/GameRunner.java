package com.company;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();

        boolean quit = false;
        while (!quit) {
            System.out.println("1=Rock, 2=Paper, 3=Scissors, 0=Quit");
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
