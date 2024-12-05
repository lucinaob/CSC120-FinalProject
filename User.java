import java.util.Random;

public class User extends Being{

    boolean knowsCode; // boolean to represent if the user has found out the truth! 
    boolean onBoard; //should this be in ship or person class? should be wherever board() is

    public User(String name, celestialBody location, int hitpoints){
        super(name, location, hitpoints);
        this.onBoard = true;
        this.knowsCode = false;
    }

    public void eat(){
        if (spaceShip.rations == 0){
            System.out.println("You are out of rations. There is nothing to eat.");
        } else{
            System.out.println("Eating rations...");
            spaceShip.rations -= 1;
            System.out.println("RATION LEVEL: " + spaceShip.rations);
        } if (spaceShip.rations < 3 && spaceShip.rations > 0){
            System.out.println("You're running low on rations. It may be time to rethink your strategy...");
        }
    }

    public void talk(Alien name){
        System.out.println(name.name.toUpperCase() + ": AHHH!");
        }
    
    // overload! 
    public void talk(Alien name, String dialog){
            System.out.println("Greetings");
            System.out.println("...");

            if (dialog.toLowerCase().contains("please")){
                System.out.println("Fine... I'll tell you where to go. But only because you asked nicely.");
                System.out.println("There is a moon in the distance.");
                System.out.println("I dropped off what was rest of your lot there");
                System.out.println("Of course, they didn't seem to like it much.");
                System.out.println("They never really do");
                System.out.println("But its for the better.");
                System.out.println("My kids and I don't really like to swim.");
                System.out.println("...");
                System.out.println("OH! You need this also - ");
                System.out.println("The worm hands (where did it get hands?) you a small silver key.");

                this.knowsCode = true; 
            }

            else{
                System.out.println("You're going to have to ask nicely.");
                System.out.println("I always told my kids to be polite when talking to a stranger."); 
                System.out.println("that or... don't talk to strangers... I forget.");
            }
        }
    

    public void attack(Being being){

        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;
        being.getHurt(randomNumber); // subtracts hitpoints from user 
        if (randomNumber > 5){
            System.out.println("You strike " + being.name + ", and it lets out a loud cry... (wait, I thought there was no noise in space?)");
        }
        else if (randomNumber <= 5){
            System.out.println("You strike " + being.name + ", and it looks at you, growing angry.");
        }

       // System.out.println(randomNumber + " hitpoints subtracted from " + being.name);
    }

    public void die(){
        this.hitpoints = 0; 
        this.alive = false;
        System.out.println("You have died...");
    }
    
    
}