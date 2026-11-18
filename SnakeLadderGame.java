//MEMBER 4 MAYANK PUJARI
public class SnakeLadderGame
{

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("    WELCOME TO SNAKE & LADDER");
        System.out.println("================================");

        // Create objects
        Dice dice = new Dice();
        Board board = new Board();

        Player player1 = new HumanPlayer("Player 1");
        Player player2 = new BotPlayer("Computer");

        Player[] players = {player1, player2};

        System.out.println("\nGame Rules:");
        board.showRules();

        boolean gameRunning = true;

        // Main game loop
        while (gameRunning) {

            for (Player player : players) {

                System.out.println("\n--------------------------------");
                System.out.println(player.getName() + "'s Turn");
                System.out.println("Current Position: "
                                   + player.getPosition());

                // Wait for player to roll
                player.WaitForRoll();

                // Roll dice
                int roll = dice.roll();

                System.out.println("Dice Result: " + roll);

                try {

                    // Check invalid move
                    if (player.getPosition() + roll > 100) {
                        throw new InvalidMoveException();
                    }

                    // Move player
                    int newPosition = player.move(roll);

                    // Check snake or ladder
                    newPosition = board.checkSquare(newPosition);

                    player.moveTo(newPosition);

                    System.out.println(player.getName()
                                       + " is now at position "
                                       + player.getPosition());

                    // Check winner
                    if (player.getPosition() == 100) {

                        throw new GameOverException();
                    }

                } 
                catch (InvalidMoveException e) {

                    System.out.println(e.getMessage());
                    System.out.println("You stay at your current position.");

                } 
                catch (GameOverException e) {

                    System.out.println("\n================================");
                    System.out.println("          GAME OVER!");
                    System.out.println(player.getName()
                                       + " WINS THE GAME!");
                    System.out.println(e.getMessage());
                    System.out.println("================================");

                    gameRunning = false;
                    break;
                }
            }
        }
    }
}
