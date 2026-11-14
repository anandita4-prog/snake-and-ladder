// import java.util.Random;
import java.util.Scanner;
public abstract class Player

{
    int HnewPosition;
    int BnewPosition;
    int HumanPosition = 0;
    int botPosition = 0;
    String name ;
    int dice;
    int newPosition;
    static Scanner sc = new Scanner(System.in);
    
    
        public int moveTo(int position) // for testing
        {
         newPosition=position ;
    
        if(newPosition>100)
        {
            System.out.println("sorry the player cannot move more than 100");
            return position;
        }
         else
        {
            return newPosition;
        }
    
        }
        public int move(int position , int dice)
        {
         newPosition=position+dice ;
    
        if(newPosition>100)
        {
            System.out.println("sorry the player cannot move more than 100");
            return position;
        }
         else
         {
            return newPosition;
        }
    
        }

































    
    // move human player 
//    public void player()
//    {
    
//    }
//    public String getName()
//    {
//     return name;
//    }
//    public int getPosition()
//    {
//     return newPosition;
//    }

   public int Humanposition(int HumanPosition , int dice)
   {

    HnewPosition = HumanPosition + dice;

   if(HnewPosition>100) 
    {
        System.out.println("sorry the player cannot move more than 100");
        HumanPosition=HnewPosition;
        return HumanPosition;
    }
    else
    {
        return HnewPosition;
    }

    }


   

    public int botposition(int botPosition , int dice)
    {
 
     BnewPosition = botPosition + dice;
 
   if(BnewPosition>100) 
     {
         System.out.println("sorry the player cannot move more than 100");
         HumanPosition=BnewPosition;
         return botPosition;
     }
     else
     {
         return BnewPosition;
     }
 
     }

      public int HumanScore()
    {
        return HnewPosition;
    }
      public int BotScore()
    {
        return BnewPosition;
    }



    



















    


    public void move()
    {
        name="human";
    }

    
    public static void main(String[] args)
    {
        // boolean gameover = false

        while(true)
        {

        }
    }


}


