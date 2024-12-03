import java.util.Scanner;


public class GameLoop {

    public static void main(String[] args) {

    // This is a "flag" to let us know when the intro loop should end
    boolean introSequence = true;
    boolean midgameSequence = true;

    // We'll use this to get input from the user.
    Scanner userInput = new Scanner(System.in);

    // Storage for user's responses
    String userResponse = "";

    System.out.println("...");
    System.out.println("The air is extremly still.");
    System.out.println("Before you is a dark expanse. Metallic walls surround you.");
    System.out.println("You have no idea where you are."); 

    // initilizes ship, user, aliens 
    celestialBody Earth = new celestialBody("Earth", 1., true, "Blue and green, with a gaping hole through the center.",  surfaceProperties.rock); 
    Moon moon = new Moon("Moon", 0.00257, false, "rocky and gray, with a stark view of the crumbling Earth on the horizon.", surfaceProperties.rock, Earth); 
    

    spaceShip ship = new spaceShip(30, 30, Earth); 
    User user = new User("name", Earth, 30); 

    // initilizing other planets + moons 
    celestialBody Mercury = new celestialBody("Mercury", 0.387, false, "small, rocky and gray. Heavily cratered and having a very thin exosphere.", surfaceProperties.rock);
    celestialBody Venus = new celestialBody("Venus", 0.723, false, "hot and turbulant. Below the thick clouds is a cratered surface eeriely resembling Earth's, but over 600 degrees warmer.", surfaceProperties.rock);
    celestialBody Mars = new celestialBody("Mars", 1.52, false, "red and dusty. Rocks and craters are abundant", surfaceProperties.rock);
    
    celestialBody Jupiter = new celestialBody("Jupiter", 5.2, false, "massive and made entierly of swirling gas. Stratified cloud decks, and an angry, swirling red spot. \n Two icy moons, Ganymede and Europa, come into view.", surfaceProperties.gas);
    Moon Europa = new Moon("Europa", 0.0042, false, "cold and icy, with stark red chasams. Something silvery glistens on the horizon", surfaceProperties.ice, Jupiter); 
    Moon Ganymede = new Moon("Ganymede", 0.007155, false, "massive, yet small relative to Jupiter. The surface appears icy and bland.", surfaceProperties.ice, Jupiter); 

    celestialBody Saturn = new celestialBody("Saturn", 9.5, false, "delicate and ringed. Almost uniform in a golden beige color, and surrounded by majestic, rocky debris. ",  surfaceProperties.gas);
    celestialBody Uranus = new celestialBody("Uranus", 19.19, false, "with a light blue hue, hosting thin, teneous rings. The rings appears almost tilted on their side!",  surfaceProperties.gas);
    celestialBody Neptune = new celestialBody("Neptune", 30., false, "distant and deep blue. A small, dark blue spot peers back at you." ,  surfaceProperties.gas);

    do{
            System.out.println("What do you wish do?");
            userResponse = userInput.nextLine().toLowerCase(); 
            // basic for now but I want to implement a running lsit of options as the game progresses somehow 

            if (userResponse.split(" ", 2)[0].equals("look")){
                if (userResponse.split(" ", 2)[1].equals("left")){
                    System.out.println("To your left is a panel with lots of buttons on it, and a small screen. The screen reads: ");
                    System.out.println("January 11th, 2036");
                    System.out.println("09:31 UTC");
                    ship.getStatus(); 
                    System.out.println("");
                }

                else if (userResponse.split(" ", 2)[1].equals("right")){
                        System.out.println("To your right is a shelf, filled with books. On the top shelf is a picture frame containing a picture of a small child holding a cat.");
                        System.out.println("");
                }

                else if (userResponse.split(" ", 2)[1].equals("backward") || userResponse.split(" ", 2)[1].equals("behind")){
                    System.out.println("Behind you is a metal room. It's dark, you can't see much from this vantage point.");
                    System.out.println("");
            }

                else if (userResponse.split(" ", 2)[1].equals("up")){
                    System.out.println("Above you is a metallic ceiling. Not much interesting is going on here.");
                    System.out.println("");
            }

            else if (userResponse.split(" ", 2)[1].equals("down")){
                System.out.println("Below you is what appears to be a control panel. A simple joystick sits before you. Next to the joystick is a red button with the words 'EJECT'. ");
                System.out.println("");
        }
            }

            else if (userResponse.split(" ", 2)[0].equals("examine")){

                if (userResponse.contains("panel")){
                    System.out.println("There isn't much else going on with the panel.");
                    System.out.println("");
                }

                if (userResponse.contains("book")){
                    System.out.println("The books are written mostly in a script you cannot understand. Some have pictures, but most are just blocks of unfamilair text.");
                    System.out.println("");
                }

                else if (userResponse.contains("photo") || userResponse.contains("picture")){
                    System.out.println("The photo is old, but in pristine condition. ");
                    System.out.println("The child looks a little familiar.");
                    System.out.println("");
                }

                    }

            else if (userResponse.split(" ", 2)[0].equals("hit") || userResponse.split(" ", 2)[0].equals("press")){
                if (userResponse.contains("eject")){
                    System.out.println("You hit the EJECT button once, twice, three times, but nothing happens. It doesn't seem to work.");
                    System.out.println("");  // incredible
                    //Or could just kill 'em lol
                }
                System.out.println("I don't know what you mean. What do you want to press?"); // this doesn't work I think i put it in the wrong place
                System.out.println("");
            }

            if (userResponse.contains("move") || userResponse.contains("joystick")){
                System.out.println("You move the joystick, and you feel the ship jerk to the side. ");
                System.out.println("Suddenly, the dark expanse before you is interrupted by a familiar sight");
                System.out.println("A large blue and green body, not unlike images of Earth that you have seen before, sits still before you.");
                System.out.println("Except unlike those images, there appears to be a massive hole through the middle.");
                System.out.println("...");
                System.out.println("");
                introSequence = false; 


        } 

        else { // dialog to catch any phrases not included earlier 
            System.out.println("I don't know what you mean. Try to 'look,' 'move,' or 'examine'");
            System.out.println("");
        }

        } while (introSequence); 

        System.out.println("A chill runs down your spine. How did this happen? When did this happen? What did this?");
            System.out.println("and most importantly... How long have you been unconcious?");
            System.out.println("");
            System.out.println("What do you do? Where do you go?");
            // grabs user input 
        do { 
            
            userResponse = userInput.nextLine().toLowerCase(); 
            
            //There must be a more efficient way to do this?
            if (userResponse.contains("go")){
                if (userResponse.contains("mars")){
                    ship.go(Mars);}
                else if (userResponse.contains("mercury")){
                    ship.go(Mercury);}
                else if (userResponse.contains("venus")){
                    ship.go(Venus);}
                else if (userResponse.contains("earth")){
                    ship.go(Earth);
                }
                else if (userResponse.contains("jupiter")){
                    ship.go(Jupiter);
                } 
                else if (userResponse.contains("neptune")){
                    ship.go(Neptune);
                } 
                else if(userResponse.contains("uranus")){
                    ship.go(Uranus);
                }
                else if(userResponse.contains("saturn")){
                    ship.go(Saturn);
                } 
            System.out.println(ship.location.name + " appears " + ship.location.description); // print what you see 
            if (!ship.location.inhabitants.isEmpty()){
                System.out.println("You can see strange worm-like shapes from your ship's window. Are they alive?");
            }
            }

            if (userResponse.toLowerCase().contains("land") && userResponse.toLowerCase().contains(ship.location.name.toLowerCase())){

                boolean landSuccess = false; 
                System.out.println("You engage your landing gears and begain your descent towards " + ship.location.name + ".");

                if (ship.location.surface == surfaceProperties.gas){ // you cannot land on a gas giant u fool
                    System.out.println("As you descend towards " + ship.location.name + ", the air grows dense and hazy, and you feel a stong graviational pull.");
                    System.out.println("The walls around you begin to cave in as the outside haze closes in.");
                    System.out.println("You feel crushed under the extreme gravity as the ship's power begins to fade...");
                    user.die();  // rip 
                    // want to have some end sequence class we can call from gameloop class I think to put when the user dies 
                }

                if (ship.location.surface == surfaceProperties.ice){
                    System.out.println("As you descend towards " + ship.location.name + ", you don't notice much difference from the stark, interplanetary air. There is little atmosphere, and the surface is glistening in reflected light.");
                    landSuccess=true; }

                if (ship.location.surface == surfaceProperties.rock){
                    System.out.println("As you descend towards " + ship.location.name + ", a thin, teneous atmosphere becomes visible. The surface appears rocky and cratered. ");
                    if (!ship.location.destroyed){
                        landSuccess=true;
                    } else{
                        System.out.println("The surface seems too damaged to land.");
                    }}
                

                if (landSuccess){
                    ship.land(ship.location); // land on location ship is at 
                }}
            

            if ((userResponse.contains("ration")) || (userResponse.contains("status"))){
                ship.getStatus(); // get status at any time 
            }
        
            else { // dialog to catch any phrases not included earlier 
                System.out.println("I don't know what you mean. Try to 'go' or 'land.'");
                System.out.println("");
            }

          } while (midgameSequence); //And user onBoard, glitched out when i tried lol
        
        }
}
