package com.company;

import java.util.Random;

public class GameLogic {

    public enum Entity {
        ROCK, PAPER, SCISSORS;

        public Entity brokenBy;

        static {
            ROCK.brokenBy = Entity.PAPER;
            PAPER.brokenBy = Entity.SCISSORS;
            SCISSORS.brokenBy = Entity.ROCK;
        }

        public boolean isBroken(Entity item) {
            return brokenBy.toString().equals(item.toString());
        }
    }

    private Entity playerChoice;
    private Entity computerChoice;
    private String result;

    public GameLogic(){
    }


    public void run(int choice) {
        yourChoice(choice);
        randomChoice();
        gameResult();
    }

    private void yourChoice(int choice) {
        switch (choice) {
            case 1:
                playerChoice = Entity.ROCK;
                break;
            case 2:
                playerChoice = Entity.PAPER;
                break;
            case 3:
                playerChoice = Entity.SCISSORS;
                break;
            default:
                playerChoice = null;
                break;
        }
    }

    private void randomChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        computerChoice = Entity.values()[choice];
    }

    private void gameResult() {
        if (playerChoice != null && computerChoice != null) {
            if (playerChoice.equals(computerChoice)) {
                result = "Draw!";
            }
            if (playerChoice.isBroken(computerChoice)) {
                result = "You lose!";
            }
            if (computerChoice.isBroken(playerChoice)){
                result = "You win!";
            }
        } else {
            result = "Incorrect input. Try again!";
        }
    }

    public Entity getPlayerChoice() {
        return playerChoice;
    }

    public Entity getComputerChoice() {
        return computerChoice;
    }

    public String getResult() {
        return result;
    }
}
