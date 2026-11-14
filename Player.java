// import java.util.Random;
import java.util.Scanner;
public abstract class Player

{

    private int position;
    private String name ;
    // int newPosition;
    
    static Scanner sc = new Scanner(System.in);

        public void player(String name)
        {
            this.name=name;
            this.position=0;
        }


        public String getName()
        {
            return name;
        }

        public int getPosition()
        {
            return position;
        }
    
    
        public void moveTo(int newPosition) // for testing
        {
            if(newPosition>=0 && newPosition<=100)
            {
             position=newPosition;
            }
          
            
    
        }


        public int move(int dice)
        {
         position=position+dice ;
    
        if(position>100)
        {
            System.out.println("sorry the player cannot move more than 100");
            return position;
        }
         else
        {
            return position;
        }
    
        }

        public abstract void WaitForRoll();
     





}

class HumanPlayer extends Player
{
    @Override 
    public void WaitForRoll()
    {
        System.out.println("Press enter to roll the dice");
        sc.nextLine();
        System.out.println("the dice is rolling.....");
    }
}

class BotPlayer extends Player
{
    @Override 
    public void WaitForRoll()
    {
        System.out.println("Bot is rolling the dice automatically...");
    }
}





    



















    
