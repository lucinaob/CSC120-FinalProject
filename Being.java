public class Being {
    String name; 
    boolean alive;
    celestialBody location; // why it sync correctly? 

    public Being(String name, celestialBody location){
        this.name = name;
        this.alive = true; // being starts out alive 
        this.location = location;
    }

    // updates location 
    public void travel(celestialBody location){
        this.location = location; 
    }

    // sets creature's alive status to false  
    public void die(){
        this.alive = false;  // sets alive to false - dead
    }

}
