public class Moon extends celestialBody {

    celestialBody host; 

    public Moon(String name, double orbitalRadius, boolean destroyed, String description, surfaceProperties surface, celestialBody host){
        super(name, orbitalRadius, destroyed, description, surface, false); 
        this.host = host; }

    
}
