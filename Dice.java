//MEMBER 1 ANANDITA MITRA 
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


}    
