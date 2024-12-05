public class Alien extends Being{

    boolean hasKey;
    boolean alive; 

    public Alien(String name, celestialBody location, boolean hasKey, int hitpoints){
        super(name, location, hitpoints);
        this.hasKey = hasKey;
        this.alive = true; 
    }

}
