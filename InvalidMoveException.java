//exception
 public class InvalidMoveException extends Exception {  
      public InvalidMoveException() {      
          super("Roll is too high, you must land on exactly 100");  
          }
          public static void main(String[] args){
            try{
                throw new InvalidMoveException();
            }
            catch(InvalidMoveException e){
              System.out.println(e.getMessage());
            }
          }
 }