public class Dice {
    private int sides;
    private int nextRoll;

    public Dice() {
        sides = 6;
        nextRoll = 0;
    }

    public int getSides() {
        return sides;
    }

    public int getNextRoll() {
         return nextRoll;
         }
         
    public void setNextRoll(int n){
        nextRoll=n;
    }
    public int roll(){
        if(nextRoll>0){
            int result=nextRoll;
            nextRoll=0;
            return result;
        }
        return (int)(Math.random()*sides)+1;
    }

    public static void main(String[]args){
        Dice d=new Dice();
        System.out.println("***WELCOME TO SNAKE AND LADDER GAME***** !!!!");
        System.out.println("Number of sides:"+d.getSides() );
        System.out.println("Random Dice Roll:"+d.roll() );
        d.setNextRoll(4);
        System.out.println("fixed dice roll:"+d.roll());
        System.out.println("next random roll:"+d.roll());
    }
}    