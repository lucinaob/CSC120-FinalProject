import java.util.ArrayList;

class celestialBody{
    String name;
    double orbitalRadius; 
    surfaceProperties surface; // description of surface 
    ArrayList<Being> inhabitants; // contains inhabitants as objects bc different classes
    boolean destroyed; 
    String description; 

    public celestialBody(String name, double orbitalRadius, boolean destroyed, String description, surfaceProperties surface){
        this.name = name; 
        this.orbitalRadius = orbitalRadius; 
        this.destroyed = destroyed; 
        this.description = description; 
        this.surface = surface; 
        this.inhabitants = new ArrayList<>();
        if(this.description == null){
            this.description = "";
        }
    }

    public void getInfested(Being alien){ // alien infests 
        this.inhabitants.add(alien); 
    }

    public void landOn(User user){ // person lands on ship
        this.inhabitants.add(user);
    }

}
