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
        } else{ //If the ship does have enough fuel,
            //Check that the ship isn't already there
            if(distance == 0){ //If the ship is already at the body, 
                //print this for the user
                System.out.println("You are already here!");
            } else{ //If the ship is not at the body,
                fuel -= distance; //descrease fuel level by distance
                this.location = bodyName; //set ship location to the body
                System.out.println("You are now in orbit about " + bodyName.name + "."); //Print that you have arrived at the body
            }
        }
        
    }

    /**
     * Landing method
     * @param bodyName - body being landed on
     * @return - if land was successful
     */
    public boolean land(celestialBody bodyName){
        //If the ship is at the body,
        if (this.location == bodyName){ 
            //The user can land!
            System.out.println("Landing on " + bodyName.name + "..."); //Print that the ship is landing
            System.out.println("Welcome to " + bodyName.name + "!"); //Print that the landing was successful
            System.out.println(bodyName.name + " appears " + bodyName.description); //Print what you see 
            this.fuel -= 1; //Decrease fuel level by one
            return true; //Return that the landing was successful
        } else{ //If not, 
            System.out.println("You cannot land on a body you are not near! Go to this body before you land."); //Print that the landing cannot happen until you are at the body
            return false; //return that landing was not successful
        }
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
        System.out.println("CURRENT STATUS: \n + Fuel = " + this.fuel + "\n + LOCATION: " + this.location.name); 
        //Print methods avaliable at different stages of the game
        if (place.equals("introSequence")){
            System.out.println("OPTIONS:\n + Look \n + Move \n + Examine");
        } else if (place.equals("midgameSequence")){
            System.out.println("OPTIONS: \n + Go\n + Land\n + Status");
        } 
    }
}