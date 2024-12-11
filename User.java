import java.util.Random;

public class User extends Being{

    //Unique attributes of a being
    boolean hasKey; // boolean to represent if the user has found out the truth! 
    boolean onBoard; //If the person is on board
    public static final String textReset = "\u001B[0m"; //String to make text default color

    /**
     * User constructor
     * @param location - location in solar system
     * @param hitpoints - # of hitpoints
     */
    public User(celestialBody location, int hitpoints){
        super(location, hitpoints); //Extend being
        this.onBoard = true; //User starts on board
        this.hasKey = false; //User starts not having the key
    }

    
    /**
     * Method to talk to an alien
     * @param name - name of the alien the user is talking to 
     * @param dialog - the user-inputted dialogue
     */
    public void userTalk(Alien name, String dialogue){

        System.out.println(name.textColor + "..."); //Starts to print things in alien's text color

        //If the user says please and doesn't know the hint already
        if (dialogue.toLowerCase().contains("please") && !this.hasKey){
            //Print hint + give user the key
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
            //Set hasKey to true
            this.hasKey = true; 
        }

        //Text output for when user doesn't say please but needs the hint still
        else if (!dialogue.toLowerCase().contains("please") && !this.hasKey){
            System.out.println("Greetings!");
            System.out.println("I have what you need...");
            System.out.println("You're just going to have to ask nicely.");
            System.out.println("I always told my kids to be polite when talking to a stranger."); 
            System.out.println("That or... don't talk to strangers... I forget.");
        }

        //Text output for if user keeps talking to alien that has the key after getting key
        else if (this.hasKey){
            System.out.println("I've already given you what you need.");
            System.out.println("Leave me be, won't you?!");
        }

        System.out.print(textReset); //Reset text color
    }
    

    /**
     * Method to attack a being
     * @param being - being to be attacked 
     */
    public void attack(Being being){

        if (this.hitpoints <= 0){ //If the user has less than 1 hitpoint
            this.die(); //User dies
        }
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1; //Random number is essentially flipping a coin — 50% chance of the user or the alien being hurt

        if (randomNumber > 5){ //If random # is above 5,
            //Alien gets hurt
            System.out.println("You strike " + being.name + ", and it lets out a loud cry... (wait, I thought there was no noise in space?)");
            being.getHurt(randomNumber); // subtracts hitpoints from alien 
            if (being.hitpoints <= 0){ //kills alien if hitpoints decrease too much
                being.die(); 
            }
        }

        else if (randomNumber <= 5){ //If random # is 5 or smaller
            //User gets hurt
            System.out.println("You strike " + being.name + ", and it looks at you, growing angry.");
            System.out.println( being.name + " lifts its tail and swings at you, knocking you over. ouch!");
            this.hitpoints -= rand.nextInt(10) + 1; // lose a random number of hitpoints.
        }

        if(this.hitpoints < 10){ //If user hitpoints are low, print warning message
            System.out.println("You're starting to feel weak...");
            System.out.println("It might be time to rethink your strategy.");
        }

        if (being.hitpoints < 5){ //If alien hitpoints are low, print that it looks like it may die
            System.out.println(being.name + " is starting to look a little pale.");
            System.out.println("Maybe you're getting somewhere!");
        }

    }

    /**
     * Die method
     */
    public void die(){
        this.hitpoints = 0; 
        this.alive = false; //Alive being false, dead is true
    }
    
    
}