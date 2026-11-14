
 public class GameOverException extends Exception { 
       public GameOverException() { 
               super("The game has already been won"); 
               }
 }
                class Main {
                public static void main(String[]args){
                    try{
                        GameOverException e=new GameOverException();
                        throw e;
                    }
                    catch(GameOverException e){
                        System.out.println(e.getMessage());
                    }
                }
               }
            