import java.util.Random;

public class Alien extends Being{

    //Unqiue ttributes of an alien
    boolean hasKey; //Whether or not an alien has the clue for the user
    public static final String textRed = "\u001B[31m"; 
    public static final String textGreen = "\u001B[32m";
    String textColor;
    public static String[] responses = {
        "Sup, brah?",
        "You wouldn't believe what happened to our homeworld, even if I told you.",
        "... You're not supposed to be here.",
        "Get off my lawn!",
        "You're not another one of those Earthlings, are you?",
        "If you're looking for your people, they aren't here. Take a left at the red gas giant, maybe.",
        "I don't know anything. Ask Red.", // hint to go to mars worm 
        "You'd be better off on... oh, what was it's name?\n Ares? Not quite. The red, rocky one!"
    };
    

    public Alien(String name, celestialBody location, boolean hasKey, int hitpoints){
        super(name, location, hitpoints); // Extends attributes of a being
        this.hasKey = hasKey;
        if(this.hasKey){
            this.textColor = textRed;
        } else{
            this.textColor = textGreen;
        }
    }

    static String talkResponses(){ 
        Random rand = new Random();
        int number = rand.nextInt(responses.length);
        String talkResponse = responses[number];
        return talkResponse;
    }

    public void alienTalk(){
        System.out.print(textColor);
        System.out.println(this.name + ": " + talkResponses());
        System.out.print(User.textReset);
    }
}
