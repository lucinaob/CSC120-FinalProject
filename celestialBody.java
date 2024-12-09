import java.util.ArrayList;

class celestialBody{

    //Attributes of a celestial body
    String name; //Name of the body
    double orbitalRadius; //Distance from the sun, measured in astronomical units: https://en.wikipedia.org/wiki/Astronomical_unit
    surfaceProperties surface; // Type of surface 
    ArrayList<Alien> inhabitants; // Alien inhabitants of a celestial body
    ArrayList<Moon> moons; //Moons of a celestial body
    boolean destroyed; //Whether or not the body has been destroyed
    String description; //A short description of the body

    
    /**
     * Constructor for a celestial body
     * @param name - Name of the body
     * @param orbitalRadius - Distance from the sun
     * @param destroyed - If the planet is destroyed
     * @param description - Short description
     * @param surface - Surface type
     * @param hasMoons - If the planet has moons
     */
    public celestialBody(String name, double orbitalRadius, boolean destroyed, String description, surfaceProperties surface, boolean hasMoons){
        this.name = name; 
        this.orbitalRadius = orbitalRadius; 
        this.destroyed = destroyed; 
        this.description = description; 
        this.surface = surface; 
        //Intializing array lists of moons and inhabitants
        this.moons = new ArrayList<>();
        this.inhabitants = new ArrayList<>();
    }

 
    /**
     * Infest planets with aliens - method to add aliens to inhabitants lists
     * @param alien - alien to be added to inhabitant list
     */
    public void getInfested(Alien alien){ 
        this.inhabitants.add(alien); 
    }

    /**
     * Method to assign a moon to a body
     * @param moon - moon to be added
     */
    public void addMoon(Moon moon){
        this.moons.add(moon); //Adds moon to body's list of moons
    }

}
