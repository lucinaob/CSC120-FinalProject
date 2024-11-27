import java.util.ArrayList;

public class User extends Being{

    boolean knowsCode;
    ArrayList<String> inventory = new ArrayList<>(); //String or objects? idk
    boolean onBoard; //should this be in ship or person class? should be wherever board() is


    public User(String name, celestialBody location){
        super(name, location);
        this.onBoard = true;
        ArrayList<String> inventory;
        this.knowsCode = false;
    }

    public void dig(){
        //rework if statements to they overlap?
        if (!inventory.contains("Shovel")){
            System.out.println("Ouch! Trying to dig with your hands is ineffective. And painful.");
        } if (onBoard = true){ 
            System.out.println("Your shovel hits metal. You can't dig here.");
        }
        //Digging should reveal something, shouldn't it? 
        //Doesn't need to be helpful, but should be something
        //Implement some kind of thing, either here on in diff planets, where digging reveals stuff
    }

    public void talk(Being name){
        //Name = being we are talking to, alien or other people?
        //IDK say stuff here
        //Either have canned things to say to the alien, or have input
            //Canned it prob easier + more in line with the game
    }

    public void eat(){
        if (spaceship.rations == 0){
            System.out.println("You are out of rations. There is nothing to eat.");
        } else{
            System.out.println("Eating rations...");
            spaceship.rations -= 1;
            System.out.println("RATION LEVEL: " + spaceship.rations);
        } if (spaceship.rations < 3 && spaceship.rations > 0){
            System.out.println("You're running low on rations. It may be time to rethink your strategy...");
        }
    }

    public void explore(){
        //
    }

    public void goTo(){
        //Necessary? I feel like 'explore' gets the job done for finding things + spaceship for going places
    }

    public void attack(Being name){
        //
    }

    
    
}