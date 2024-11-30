import java.util.ArrayList;

class celestialBody{
    String name;
    int orbitalRadius; 
    Number temperature; 
    ArrayList<Being> inhabitants; // contains inhabitants as objects bc different classes
    boolean destroyed; 
    String description; 

    public celestialBody(String name, int orbitalRadius, Number temp, boolean destroyed, String description){
        this.name = name; 
        this.orbitalRadius = orbitalRadius; 
        this.temperature = temp; 
        this.destroyed = destroyed; 
        this.description = ""; 
    }

    public void getInfested(Being alien){ // alien infests 
        this.inhabitants.add(alien); 
    }

    public void landOn(User user){ // person lands on ship
        this.inhabitants.add(User user); 

    }


}
