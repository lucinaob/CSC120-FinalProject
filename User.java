import java.util.Random;

public class User extends Being{

    //Unique attributes of a being
    boolean knowsCode; // boolean to represent if the user has found out the truth! 
    boolean onBoard; //should this be in ship or person class? should be wherever board() is
    public static final String ANSI_RED = "\u001B[31m"; 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static String[] responses = {
        "Sup, brah?",
        "You wouldn't believe what happened to our homeworld, even if I told you.",
        "... You're not supposed to be here.",
        "Get off my lawn!",
        "You're not another one of those Earthlings, are you?",
        "If you're looking for your people, they aren't here. Take a left at the red gas giant, maybe.",
        "I don't know anything. Ask Red.", // hint to go to mars worm 
    };

    public User(String name, celestialBody location, int hitpoints){
        super(name, location, hitpoints);
        this.onBoard = true;
        this.knowsCode = false; // CHANGE 
    }

    static String talkResponses(){ 
        Random rand = new Random();
        int number = rand.nextInt(responses.length);
        String talkResponse = responses[number];
        return talkResponse;
      }

    public void talk(Alien name){
        System.out.print(ANSI_GREEN);
        System.out.println(name.name + ": " + talkResponses());
        System.out.print(ANSI_RESET);
        }
    
    // move to alien?
    public void talk(Alien name, String dialog){

            System.out.println(ANSI_RED + "...");

            if (dialog.toLowerCase().contains("please") && !this.knowsCode){
                System.out.println(ANSI_RED + "Fine... I'll tell you where to go. But only because you asked nicely.");
                System.out.println("There is a moon in the distance.");
                System.out.println("I dropped off what was rest of your lot there");
                System.out.println("Of course, they didn't seem to like it much.");
                System.out.println("They never really do");
                System.out.println("But its for the better.");
                System.out.println("My kids and I don't really like to swim.");
                System.out.println("...");
                System.out.println("OH! You need this also - " + ANSI_RESET);
                System.out.println("The worm hands (where did it get hands?) you a small silver key.");
                this.knowsCode = true; 
            }

            else if (!dialog.toLowerCase().contains("please") && !this.knowsCode){
                System.out.println("Greetings!");
                System.out.println("I have what you need...");
                System.out.println("You're just going to have to ask nicely.");
                System.out.println("I always told my kids to be polite when talking to a stranger."); 
                System.out.println("That or... don't talk to strangers... I forget." + ANSI_RESET);
            }

            else if (this.knowsCode){
                System.out.println("I've already given you what you need.");
                System.out.println("Leave me be, won't you?!" + ANSI_RESET);
            }
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
            System.out.println(name + " is starting to look a little pale.");
            System.out.println("Maybe you're getting somewhere!");
        }

    }

    public void die(){
        this.hitpoints = 0; 
        this.alive = false;
       // System.out.println("You have died...");
    }
    
    
}