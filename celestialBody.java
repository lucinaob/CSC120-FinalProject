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

    public void getInfested(Being alien){
        this.inhabitants.add(alien); 
    }


}
