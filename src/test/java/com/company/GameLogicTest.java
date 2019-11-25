package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void testYourChoice() {
        GameLogic gameLogic = new GameLogic();

        gameLogic.run(1);
        assertEquals(gameLogic.getPlayerChoice(), GameLogic.Entity.ROCK);

        gameLogic.run(2);
        assertEquals(gameLogic.getPlayerChoice(), GameLogic.Entity.PAPER);

        gameLogic.run(3);
        assertEquals(gameLogic.getPlayerChoice(), GameLogic.Entity.SCISSORS);

        gameLogic.run(5);
        assertNull(gameLogic.getPlayerChoice());
    }

    @Test
    public void testGameResult1() {
        //player choice = Rock
        GameLogic gameLogic = new GameLogic();
        gameLogic.run(1);

        GameLogic.Entity computerChoice = gameLogic.getComputerChoice();

        if (computerChoice.equals(GameLogic.Entity.ROCK)) {
            assertEquals(gameLogic.getResult(), "Draw!");
        }
        if (computerChoice.equals(GameLogic.Entity.PAPER)) {
            assertEquals(gameLogic.getResult(), "You lose!");
        }
        if (computerChoice.equals(GameLogic.Entity.SCISSORS)) {
            assertEquals(gameLogic.getResult(), "You win!");
        }
    }

    @Test
    public void testGameResult2() {
        //player choice = Paper
        GameLogic gameLogic = new GameLogic();
        gameLogic.run(2);

        GameLogic.Entity computerChoice = gameLogic.getComputerChoice();

        if (computerChoice.equals(GameLogic.Entity.ROCK)) {
            assertEquals(gameLogic.getResult(), "You win!");
        }
        if (computerChoice.equals(GameLogic.Entity.PAPER)) {
            assertEquals(gameLogic.getResult(), "Draw!");
        }
        if (computerChoice.equals(GameLogic.Entity.SCISSORS)) {
            assertEquals(gameLogic.getResult(), "You lose!");
        }
    }

    @Test
    public void testGameResult3() {
        //player choice = Scissors
        GameLogic gameLogic = new GameLogic();
        gameLogic.run(3);

        GameLogic.Entity computerChoice = gameLogic.getComputerChoice();

        if (computerChoice.equals(GameLogic.Entity.ROCK)) {
            assertEquals(gameLogic.getResult(), "You lose!");
        }
        if (computerChoice.equals(GameLogic.Entity.PAPER)) {
            assertEquals(gameLogic.getResult(), "You win!");
        }
        if (computerChoice.equals(GameLogic.Entity.SCISSORS)) {
            assertEquals(gameLogic.getResult(), "Draw!");
        }
    }

    @Test
    public void testGameResultAny() {
        //player choice = any incorrect number
        GameLogic gameLogic = new GameLogic();
        gameLogic.run(7);

        GameLogic.Entity computerChoice = gameLogic.getComputerChoice();

        if (computerChoice.equals(GameLogic.Entity.ROCK)) {
            assertEquals(gameLogic.getResult(), "Incorrect input. Try again!");
        }
        if (computerChoice.equals(GameLogic.Entity.PAPER)) {
            assertEquals(gameLogic.getResult(), "Incorrect input. Try again!");
        }
        if (computerChoice.equals(GameLogic.Entity.SCISSORS)) {
            assertEquals(gameLogic.getResult(), "Incorrect input. Try again!");
        }
    }
}
