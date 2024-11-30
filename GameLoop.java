import java.util.Scanner;


public class GameLoop {

    public static void main(String[] args) {

    // This is a "flag" to let us know when the loop should end
    boolean stillPlaying = true;

    // We'll use this to get input from the user.
    Scanner userInput = new Scanner(System.in);

    // Storage for user's responses
    String userResponse = "";

    try{  // prints intro to game, try/catch block to pause for dramatic effect 
        System.out.println("...");
        Thread.sleep(1000);  
        System.out.println("the air is extremly still.");
        Thread.sleep(1500);  
        System.out.println("Before you is a dark expanse. Metallic walls surround you.");
        Thread.sleep(1600);  
        System.out.println("You have no idea where you are."); 
    } catch (InterruptedException e) {}

    // initilizes ship, user, aliens 
    spaceShip ship = new spaceShip(30, 30); 
    celestialBody Earth = new celestialBody("Earth", 1, 273, true, "Blue and green, with a gaping hole through the center."); 
    User user = new User("name", Earth, 30); 

do{
        System.out.println("What do you wish do?");
        userResponse = userInput.nextLine().toLowerCase(); 
        // basic for now but I want to implement a running lsit of options as the game progresses somehow 

        if (userResponse.split(" ", 2)[0].equals("look")){
            if (userResponse.split(" ", 2)[1].equals("left")){
                System.out.println("To your left is a panel with lots of buttons on it, and a small screen. The screen reads: ");
                System.out.println("January 11th, 2036");
                System.out.println("09:31 UTC");
                ship.getStatus(); }

            else if (userResponse.split(" ", 2)[1].equals("right")){
                    System.out.println("To your right is a shelf, filled with books. On the top shelf is a picture frame containing a picture of a small child holding a cat.");
                    System.out.println("");
            }
        }

        else if (userResponse.split(" ", 2)[0].equals("examine")){

            if (userResponse.contains("panel")){
                System.out.println("There isn't much else going on with the panel.");
                System.out.println("");
            }

            if (userResponse.contains("book")){
                System.out.println("The books are written mostly in a script you cannot understand. Some have pictures, but most are just blocks of unfamilair text.");
                System.out.println("");
            }

            else if (userResponse.contains("photo")){
                System.out.println("The photo is old, but in pristine condition. ");
                System.out.println("The child looks a little familiar.");
                System.out.println("");
            }
                }

        else {
            System.out.println("I don't know what you mean. Try to 'look', or 'examine'");
            System.out.println("");
        }


    } while (stillPlaying); 

    }
}
