package ua.epam.simpleGame;

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

    public enum GameResult {
        DRAW, YOU_LOSE, YOU_WIN, INCORRECT_INPUT
    }

    private Entity playerChoice;
    private Entity computerChoice;
    private GameResult result;

    public GameLogic() {
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
                result = GameResult.DRAW;
            }
            if (playerChoice.isBroken(computerChoice)) {
                result = GameResult.YOU_LOSE;
            }
            if (computerChoice.isBroken(playerChoice)) {
                result = GameResult.YOU_WIN;
            }
        } else {
            result = GameResult.INCORRECT_INPUT;
        }
    }

    public Entity getPlayerChoice() {
        return playerChoice;
    }

    public Entity getComputerChoice() {
        return computerChoice;
    }

    public GameResult getResult() {
        return result;
    }
}
