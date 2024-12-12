import java.util.Random;

public class Alien extends Being{

    //Unqiue ttributes of an alien
    boolean hasKey; //Whether or not an alien has the clue for the user
    //Strings to change text color
    public static final String textRed = "\u001B[31m"; 
    public static final String textGreen = "\u001B[32m";
    String textColor; //Which text color to use
    //Canned responses for non-interactive aliens
    public static String[] responses = {
        "Sup, brah?",
        "You wouldn't believe what happened to our homeworld, even if I told you.",
        "... You're not supposed to be here.",
        "Get off my lawn!",
        "You're not another one of those Earthlings, are you?",
        "If you're looking for your people, they aren't here. Take a left at the red gas giant, maybe.", //Hint to go near jupiter
        "I don't know anything. Ask Red.", // hint to go to mars worm 
        "You'd be better off on... oh, what was it's name?\nAres? Not quite. The red, rocky one!" //Hint to go to mars
    };
    

    /**
     * Constructor for an alien
     * @param name - name of an alien
     * @param location - place in the solar system
     * @param hasKey - if the alien has the key to Europa
     * @param hitpoints - hitpoints of the alien
     */
    public Alien(String name, celestialBody location, boolean hasKey, int hitpoints){
        super(name, location, hitpoints); // Extends attributes of a being
        this.hasKey = hasKey;
        //Change text color based on whether or not the alien has the key
        if(this.hasKey){
            this.textColor = textRed;
        } else{
            this.textColor = textGreen;
        }
    }

    /**
     * Canned response method
     * @return - return a canned response
     */
    static String talkResponses(){ 
        Random rand = new Random();
        //Randomly select a random canned response
        int number = rand.nextInt(responses.length);
        String talkResponse = responses[number];
        //Return the canned response that was randomly chosen
        return talkResponse;
    }

    /**
     * Method for the alien to talk
     */
    public void alienTalk(){
        System.out.print(textColor); //Change the output color to the color fo the alien's text
        System.out.println(this.name + ": " + talkResponses()); //Print a given response
        System.out.print(User.textReset); //Reset text color
    }
}
