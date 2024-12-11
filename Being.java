public class Being {

    //Attributes of a being
    String name; //Name of the being
    boolean alive; //Whether or not the being is alive
    int hitpoints; //# of hitpoints a being has
    celestialBody location; //Location in the solar system

    /**
     * Being constructor
     * @param name - name of the being
     * @param location - location in the solar system
     * @param hitpoints - # of hitpoints
     */
    public Being(String name, celestialBody location, int hitpoints){
        this.name = name;
        this.hitpoints = hitpoints; 
        this.alive = true; // Being always starts out alive 
        this.location = location;
    }

    /**
     * Overloaded constructor for beings without names
     * @param location - location in solar system
     * @param hitpoints - # of hitpoints
     */
    public Being(celestialBody location, int hitpoints){
        this.hitpoints = hitpoints; 
        this.alive = true; // Being always starts out alive 
        this.location = location;
    }

    /**
     * Method to remove hitpoints when a being is hurt
     * @param hitpoints - the number of hitpoints to remove from a being
     */
    public void getHurt(int hitpoints){
        this.hitpoints -= hitpoints; //Subtracts hitpoints from total the being has
    }

    /**
     * Method for death of a being */  
    public void die(){
        this.hitpoints = 0; // Set hitpoints to 0
        this.alive = false;  // Sets alive to false - dead
    }

}
