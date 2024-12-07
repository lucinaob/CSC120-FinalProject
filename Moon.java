public class Moon extends celestialBody {

    //Unique attributes of a moon
    celestialBody host; //Celestial body the moon orbits around

    /**
     * Constructor for a moon
     * @param name - Moon's name
     * @param orbitalRadius - Distance from the sun in astronomical units
     * @param destroyed - whether or not the moon is destroyed
     * @param description - short description of the moon
     * @param surface - surface type of the moon
     * @param host - host body
     */
    public Moon(String name, double orbitalRadius, boolean destroyed, String description, surfaceProperties surface, celestialBody host){
        //Extending attributes of a body
        super(name, orbitalRadius, destroyed, description, surface, false); 
        //Adding unique attributes
        this.host = host; }

    
}
