//MEMBER 3 KUMUD YADU 
public class Board {

    private int[] snakeHeads;
    private int[] snakeTails;
    private int[] ladderBottoms;
    private int[] ladderTops;

    public Board() {
        snakeHeads = new int[] {99, 45};
        snakeTails = new int[] {10, 5};
        ladderBottoms = new int[] {15, 60};
        ladderTops = new int[] {35, 85};
    }

    public int[] getSnakeHeads() {
        return snakeHeads.clone();
    }

    public int[] getSnakeTails() {
        return snakeTails.clone();
    }

    public int[] getLadderBottoms() {
        return ladderBottoms.clone();
    }

    public int[] getLadderTops() {
        return ladderTops.clone();
    }

    public int checkSquare(int position) {

        for (int i = 0; i < snakeHeads.length; i++) {
            if (position == snakeHeads[i]) {
                System.out.println("OH NO! Bitten by a snake!");
                return snakeTails[i];
            }
        }

        for (int i = 0; i < ladderBottoms.length; i++) {
            if (position == ladderBottoms[i]) {
                System.out.println("YAY! Climbed a ladder!");
                return ladderTops[i];
            }
        }

        return position;
    }

    public void showRules() {

        System.out.println("\nSnakes (head -> tail):");

        for (int i = 0; i < snakeHeads.length; i++) {
            System.out.println(snakeHeads[i] + " -> " + snakeTails[i]);
        }

        System.out.println("Ladders (bottom -> top):");

        for (int i = 0; i < ladderBottoms.length; i++) {
            System.out.println(ladderBottoms[i] + " -> " + ladderTops[i]);
        }

        System.out.println();
    }

    public boolean isValid() {

        if (snakeHeads.length != snakeTails.length ||
            ladderBottoms.length != ladderTops.length) {
            return false;
        }

        for (int i = 0; i < snakeHeads.length; i++) {
            if (snakeHeads[i] <= snakeTails[i]) {
                return false;
            }
        }

        for (int i = 0; i < ladderBottoms.length; i++) {
            if (ladderTops[i] <= ladderBottoms[i]) {
                return false;
            }
        }

        return true;
    }
}


