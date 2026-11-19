//MEMBER 4 MAYANK PUJARI 
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        boolean running = true;

        // Welcome screen
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("          SNAKE AND LADDER");
        System.out.println("==========================================");
        System.out.println("       Welcome to the Game!");
        System.out.println("       Player vs Computer");
        System.out.println("==========================================");

        while(running) {

            System.out.println("\n");
            System.out.println("+----------------------------------------+");
            System.out.println("|               MAIN MENU                |");
            System.out.println("+----------------------------------------+");
            System.out.println("|                                        |");
            System.out.println("|   1.  Play a Game                      |");
            System.out.println("|   2.  Play a Game (Test Mode)          |");
            System.out.println("|   3.  Show Snakes and Ladders          |");
            System.out.println("|   4.  Exit Game                        |");
            System.out.println("|                                        |");
            System.out.println("+----------------------------------------+");

            System.out.print("\nEnter your choice: ");

            String input = sc.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            }
            catch(NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number.");
                continue;
            }

            switch(choice) {

                case 1:
                    Game game1 = new Game(sc, false);
                    game1.play();
                    break;

                case 2:
                    Game game2 = new Game(sc, true);
                    game2.play();
                    break;

                case 3:
                    System.out.println("\n");
                    System.out.println("==========================================");
                    System.out.println("             BOARD INFORMATION");
                    System.out.println("==========================================");
                    board.showRules();
                    System.out.println("==========================================");
                    break;

                case 4:
                    System.out.println("\n");
                    System.out.println("==========================================");
                    System.out.println("       THANK YOU FOR PLAYING!");
                    System.out.println("          SEE YOU AGAIN!");
                    System.out.println("==========================================");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid choice! Select between 1 and 4.");
            }
        }

        sc.close();
    }
}
