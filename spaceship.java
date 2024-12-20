import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class spaceShip{
    
    //Attributes of a spaceship
    double fuel; //Fuel level
    celestialBody location;  //Location in solar system, relative to a celestial body

    /**
     * Constructor for a spaceship
     * @param fuel - Fuel level
     * @param location - closest celestial body to the moon
     */
    public spaceShip(double fuel, celestialBody location){
        this.fuel = fuel;
        this.location = location;
    }

    /**
     * Boarding method
     * @param user - user boarding
     */
    public void board(User user){ 
        //If the user is on board already,
        if(user.onBoard){ 
            //Print that the user cannot board again
            System.out.println("You are already on this ship and cannot board.");
        } else{ //If the user isn't on board,
            //Change the user's board status to on board
            user.onBoard = true;
            //Print message confirming boarding
            System.out.println("Welcome aboard!");
        }
    }

    /**
     * Unboarding method
     * @param user - user unboarding
     */
    public void unboard(User user){
        //If user is already not on the spaceship,
        if(!user.onBoard){
            //Print that the user cannot unboard again
            System.out.println("You can't unboard a ship you're not on!");
        } else{ //if they are on board,
            user.onBoard = false; //Change user's board status to not on board
            System.out.println("Now unboarding..."); //Print message confirming unboarding
        }
    }

    /**
     * Go method
     * @param bodyName - body the ship is traveling to
     */
    public void go(celestialBody bodyName){
        //Calculate distance between the ship and the celestial body
        double distance = Math.abs(bodyName.orbitalRadius - this.location.orbitalRadius);
        //If the ship doesn't have enough fuel to go there,
        if (fuel < distance){
            //Print that the ship cannot go there
            System.out.println("You don't have enough fuel to go here!");
            System.out.println("");
        } else{ //If the ship does have enough fuel,
            //Check that the ship isn't already there
            if(distance == 0){ //If the ship is already at the body, 
                //print this for the user
                System.out.println("You are already here!");
                System.out.println("");

            } else{ //If the ship is not at the body,
                fuel -= distance; //descrease fuel level by distance
                this.location = bodyName; //set ship location to the body
                System.out.println("You are now in orbit about " + bodyName.name + "."); //Print that you have arrived at the body
                bodyName.display(); 

            }
        }
    }

    /**
     * Landing method
     * @param bodyName - body being landed on
     * @return - if land was successful
     */
    public boolean land(celestialBody bodyName){
        boolean landReturn = false;
        //If the ship is at the body,
        if (this.location == bodyName && !this.location.destroyed){ 
            //The user can land!
          //  System.out.println("Landing on " + bodyName.name + "..."); //Print that the ship is landing
         //   System.out.println("Welcome to " + bodyName.name + "!"); //Print that the landing was successful
            System.out.println(bodyName.name + " appears " + bodyName.description); //Print what you see 
            this.fuel -= 1; //Decrease fuel level by one
            landReturn = true; //Return that the landing was successful
        } else if (!this.location.destroyed){ //If not, 
            System.out.println("You cannot land on a body you are not near! Go to this body before you land."); //Print that the landing cannot happen until you are at the body
        } else if (this.location.destroyed){
            System.out.println("The surface seems to damaged to land...");
        }
        return landReturn;
    }

    /**
     * Take off method
     * @param bodyName - location to be taken off from
     */
    public void takeOff(celestialBody bodyName){
        //If the ship is at the body,
        if (this.location.orbitalRadius == bodyName.orbitalRadius){ 
            //Print that you have taken off
            System.out.println("Taking off from " + bodyName.name + "..."); 
            System.out.println("You are now in orbit about " + bodyName.name + ".");
            this.fuel -= 1; //Decrease fuel levels by one
        } else{ //If not,
            //Print that you can't take off
            System.out.println("You are not on this body and cannot take off from it.");
        }
    }

    /**
     * Get status method
     * @param place - part of the game the player is in
     */
    public void getStatus(String place){
        //Print fuel status and location
        System.out.println("| CURRENT STATUS: \n |  + Fuel = " + this.fuel + "         |\n |  + LOCATION: " + this.location.name + "      |"); 
        System.out.println("-------------------------");
       // Print methods avaliable at different stages of the game
        if (place.equals("introSequence")){
            System.out.println("OPTIONS: \n + look [up/left/right/down] \n + examine [object] \n + move [object]");
        } else if (place.equals("orbitSequence")){
            System.out.println("OPTIONS:\n + Go to [planet/moon name] \n + Land on [planet/moon name]");
        } else if (place.equals("onBody")){
            System.out.println("OPTIONS: \n + Unboard \n + Board \n + Talk \n + Fight \n + Take off \n" );
        } 
    }

    /**
     * Printing ASCII map of the solar system
     */
    public void displaySS(){

        try {
            File myFile = new File("planet_images/" + "ss.txt"); // Read text file
            Scanner fileReader = new Scanner(myFile); // <- Same kind of object we used to read from the command line! But instead of System.in, we're reading from the file

            // Loop until we run out of lines
            while (fileReader.hasNextLine()) {
                //Print next line of the text file
                String data = fileReader.nextLine();
                System.out.println(data);
            }

            // Tidy up
            fileReader.close();
        
        } catch (FileNotFoundException e) { // Catch if there is an issue reading the file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
