import java.util.Random;

public class User extends Being{

    //Unique attributes of a being
    boolean knowsCode; // boolean to represent if the user has found out the truth! 
    boolean onBoard; //should this be in ship or person class? should be wherever board() is
    public static final String textReset = "\u001B[0m";

    public User(String name, celestialBody location, int hitpoints){
        super(name, location, hitpoints);
        this.onBoard = true;
        this.knowsCode = false; // CHANGE 
    }

    
    // move to alien?
    public void userTalk(Alien name, String dialog){

            System.out.println(name.textColor + "...");

            if (dialog.toLowerCase().contains("please") && !this.knowsCode){
                System.out.println(name.textColor + "Fine... I'll tell you where to go. But only because you asked nicely.");
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

            else if (!dialog.toLowerCase().contains("please") && !this.knowsCode){
                System.out.println("Greetings!");
                System.out.println("I have what you need...");
                System.out.println("You're just going to have to ask nicely.");
                System.out.println("I always told my kids to be polite when talking to a stranger."); 
                System.out.println("That or... don't talk to strangers... I forget.");
            }

            else if (this.knowsCode){
                System.out.println("I've already given you what you need.");
                System.out.println("Leave me be, won't you?!");
            }

            System.out.println(textReset);
        }
    

    public void attack(Being being){

        if (this.hitpoints <= 0){
            this.die(); 
        }
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;

        if (randomNumber > 5){
            System.out.println("You strike " + being.name + ", and it lets out a loud cry... (wait, I thought there was no noise in space?)");
            being.getHurt(randomNumber); // subtracts hitpoints from user 
            if (being.hitpoints <= 0){ //kill if hitpoints decrease too much
                being.die(); 
            }
        }

        else if (randomNumber <= 5){
            System.out.println("You strike " + being.name + ", and it looks at you, growing angry.");
            System.out.println( being.name + " lifts its tail and swings at you, knocking you over. ouch!");
            this.hitpoints -= rand.nextInt(10) + 1; // lose a random number of hitpoints.
        }

        if(this.hitpoints < 10){
            System.out.println("You're starting to feel weak...");
            System.out.println("It might be time to rethink your strategy.");
        }

        if (being.hitpoints < 5){
            System.out.println(being.name + " is starting to look a little pale.");
            System.out.println("Maybe you're getting somewhere!");
        }

    }

    public void die(){
        this.hitpoints = 0; 
        this.alive = false;
       // System.out.println("You have died...");
    }
    
    
}