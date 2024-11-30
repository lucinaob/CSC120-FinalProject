public class Being {
    String name; 
    boolean alive;
    static int hitpoints; 
    celestialBody location; // why it sync correctly? 

    public Being(String name, celestialBody location, int hitpoints){
        this.name = name;
        this.hitpoints = hitpoints; 
        this.alive = true; // being starts out alive 
        this.location = location;
    }

    // updates location 
    public void travel(celestialBody location){
        this.location = location; 
    }

    public void getHurt(int hitpoints){
        this.hitpoints -= hitpoints; // subtracts hitpoints 
    }

    // sets creature's alive status to false  
    public void die(){
        this.hitpoints = 0; 
        this.alive = false;  // sets alive to false - dead
    }

}
