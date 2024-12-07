public class Alien extends Being{

    //Unqiue ttributes of an alien
    boolean hasKey; //Whether or not an alien has the clue for the user

    public Alien(String name, celestialBody location, boolean hasKey, int hitpoints){
        super(name, location, hitpoints); // Extends attributes of a being
        this.hasKey = hasKey;
    }

}
