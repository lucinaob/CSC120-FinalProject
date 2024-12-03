import java.util.ArrayList;

class celestialBody{
    String name;
    double orbitalRadius; 
    surfaceProperties surface; // description of surface 
    ArrayList<Being> inhabitants; // contains inhabitants as objects bc different classes
    ArrayList<Moon> moons; // contains inhabitants as objects bc different classes
    boolean destroyed; 
    String description; 
    boolean hasMoons; 

    public celestialBody(String name, double orbitalRadius, boolean destroyed, String description, surfaceProperties surface, boolean hasMoons){
        this.name = name; 
        this.orbitalRadius = orbitalRadius; 
        this.destroyed = destroyed; 
        this.description = description; 
        this.surface = surface; 
        this.hasMoons = hasMoons; 
        this.moons = new ArrayList<>(); 
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

    public void addMoon(Moon moon){
        this.moons.add(moon); 
    }

}
