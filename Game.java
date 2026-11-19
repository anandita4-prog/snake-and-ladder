//MEMBER 4 MAYANK PUJARI 
import java.util.Scanner;

public class Game {

    private Player[] players;
    private Dice dice;
    private Board board;
    private boolean gameOver;
    private boolean testMode;
    private Scanner sc;

    public Game(Scanner sc, boolean testMode) {

        this.sc = sc;
        this.testMode = testMode;

        dice = new Dice();
        board = new Board();

        gameOver = false;

        players = new Player[2];

        players[0] = new HumanPlayer("Player 1", sc);
        players[1] = new BotPlayer("Computer");
    }

    // Displays the game heading
    private void showGameHeader() {

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("             SNAKE AND LADDER");
        System.out.println("==========================================");

        if(testMode) {
            System.out.println("              TEST MODE");
        }
        else {
            System.out.println("              NORMAL MODE");
        }

        System.out.println("------------------------------------------");
        System.out.println("          REACH SQUARE 100 TO WIN");
        System.out.println("==========================================");
    }

    // Displays both players' positions
    private void showScoreboard() {

        System.out.println("\n--------------- SCOREBOARD ---------------");

        for(Player p : players) {

            System.out.println(
                p.getName() + " : Square " + p.getPosition()
            );
        }

        System.out.println("------------------------------------------");
    }

    // Handles one player's turn
    public void playTurn(Player p) throws GameOverException {

        if(gameOver) {
            throw new GameOverException();
        }

        System.out.println("\n");
        System.out.println("------------------------------------------");
        System.out.println("              " + p.getName());
        System.out.println("                YOUR TURN");
        System.out.println("------------------------------------------");

        System.out.println("Current Position : " + p.getPosition());

        p.waitForRoll();

        // Test mode dice input
        if(testMode) {

            int choice;

            while(true) {

                System.out.print(
                    "Enter dice number (1-6) or 0 for random: "
                );

                choice = readInteger();

                if(choice >= 0 && choice <= 6) {
                    break;
                }

                System.out.println("Invalid dice value! Enter 0-6.");
            }

            dice.setNextRoll(choice);
        }

        // Roll the dice
        int roll = dice.roll();

        System.out.println("\n");
        System.out.println("+----------------------------------------+");
        System.out.println("             DICE RESULT: " + roll);
        System.out.println("+----------------------------------------+");

        try {

            int newPosition = p.move(roll);

            System.out.println(
                "Moving from " + (newPosition - roll)
                + " to " + newPosition
            );

            // Check for snakes and ladders
            int finalPosition = board.checkSquare(newPosition);

            p.moveTo(finalPosition);

            System.out.println("\nNew Position: " + p.getPosition());

            // Check winner
            if(p.getPosition() == 100) {

                gameOver = true;

                System.out.println("\n");
                System.out.println("******************************************");
                System.out.println("              CONGRATULATIONS!");
                System.out.println("******************************************");
                System.out.println("              " + p.getName());
                System.out.println("               IS THE WINNER!");
                System.out.println("******************************************");
            }

        }
        catch(InvalidMoveException e) {

            System.out.println("\n" + e.getMessage());
            System.out.println("You remain at square " + p.getPosition());
        }

        showScoreboard();

        System.out.println("------------------------------------------");
    }

    // Starts the game
    public void play() {

        showGameHeader();

        // Ask starting positions in test mode
        if(testMode) {

            System.out.println("\nEnter starting positions:");

            for(Player p : players) {

                int start;

                while(true) {

                    System.out.print(
                        p.getName() + " starting position (0-100): "
                    );

                    start = readInteger();

                    if(start >= 0 && start <= 100) {
                        break;
                    }

                    System.out.println("Invalid position! Try again.");
                }

                p.moveTo(start);
            }

            showScoreboard();
        }

        try {

            while(true) {

                for(Player p : players) {

                    playTurn(p);
                }
            }

        }
        catch(GameOverException e) {

            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("               GAME OVER");
            System.out.println("==========================================");
            System.out.println(e.getMessage());
            System.out.println("==========================================");
        }
    }

    // Handles invalid integer input
    private int readInteger() {

        while(true) {

            String input = sc.nextLine();

            try {

                return Integer.parseInt(input);

            }
            catch(NumberFormatException e) {

                System.out.print("Please enter a valid integer: ");
            }
        }
    }
}

