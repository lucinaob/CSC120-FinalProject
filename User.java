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

    public void talk(Being name){
        System.out.println(name.name.toUpperCase() + ": AHHH!");
        //IDK say stuff here
        //Either have canned things to say to the alien, or have input
            //Canned it prob easier + more in line with the game // i agree 

        //Should there be a way of having to talk to a certain alien x amount of times before you get the key? so it's not one and done?
    }

    public void attack(Being being){

        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;
        being.getHurt(randomNumber); // subtracts hitpoints from user 
        System.out.println(randomNumber + " hitpoints subtracted from " + being.name);
    }

    public void die(){
        this.hitpoints = 0; 
        this.alive = false;
        System.out.println("You have died...");
    }
    
    
}