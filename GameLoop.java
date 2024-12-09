import java.util.Scanner;


public class GameLoop {

    public static void main(String[] args) {

        // This is a "flag" to let us know when the intro loop should end
        boolean introSequence = true;
        boolean midgameSequence = true;
        boolean landSuccess = false;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        System.out.println(User.textReset);
        try{
            System.out.println("...");
            Thread.sleep(500);
            System.out.println("The air is extremly still.");
            Thread.sleep(1000);
            System.out.println("Before you is a dark expanse. Metallic walls surround you.");
            Thread.sleep(2000);
            System.out.println("You have no idea where you are."); 
            Thread.sleep(2000);
            System.out.println("");
            System.out.println("OPTIONS: \n + look [up/left/right/down/backwards] \n + examine [object] \n + move [object]");
            System.out.println("");
        } catch (InterruptedException e) {}

        // initilizes ship, user, aliens 
        celestialBody Earth = new celestialBody("Earth", 1., true, "blue and green, with a gaping hole through the center.",  surfaceProperties.rock, true); 
        Moon moon = new Moon("Moon", 0.00257, false, "rocky and gray, with a stark view of the crumbling Earth on the horizon.", surfaceProperties.rock, Earth); 

        spaceShip ship = new spaceShip(100, Earth); 
        User user = new User("name", Earth, 30); 

        // initilizing other planets + moons 
        celestialBody Mercury = new celestialBody("Mercury", 0.387, false, "small, rocky and gray. Heavily cratered and having a very thin exosphere.", surfaceProperties.rock, false);
        celestialBody Venus = new celestialBody("Venus", 0.723, false, "hot and turbulant. Below the thick clouds is a cratered surface eeriely resembling Earth's, but over 600 degrees warmer.", surfaceProperties.rock, false);
        celestialBody Mars = new celestialBody("Mars", 1.52, false, "red and dusty. Rocks and craters are abundant", surfaceProperties.rock, false);
        
        celestialBody Jupiter = new celestialBody("Jupiter", 5.2, false, "massive and made entierly of swirling gas. Stratified cloud decks, and an angry, swirling red spot. \n Two icy moons, Ganymede and Europa, come into view.", surfaceProperties.gas, true);
        Moon Europa = new Moon("Europa", 0.0042, false, "cold and icy, with deep red chasams. Something silvery juts out from the ground near your ship. \n You can almost make out the shape of a door?", surfaceProperties.ice, Jupiter); 
        Moon Ganymede = new Moon("Ganymede", 0.007155, false, "massive, yet small relative to Jupiter. The surface appears icy and bland.", surfaceProperties.ice, Jupiter); 

        Jupiter.addMoon(Europa);
        Jupiter.addMoon(Ganymede); 

        celestialBody Saturn = new celestialBody("Saturn", 9.5, false, "delicate and ringed. Almost uniform in a golden beige color, and surrounded by majestic, rocky debris. ",  surfaceProperties.gas, false);
        celestialBody Uranus = new celestialBody("Uranus", 19.19, false, "a light blue hue, hosting thin, teneous rings. The rings appears almost tilted on their side!",  surfaceProperties.gas, false);
        celestialBody Neptune = new celestialBody("Neptune", 30., false, "a distant and deep blue. A small, dark blue spot peers back at you." ,  surfaceProperties.gas, false);
        celestialBody Pluto = new celestialBody("Pluto", 39.5, false, "small and desolate. A small red heart appears on its side." ,  surfaceProperties.rock, false);


        //initializing aliens
        Alien alienOne = new Alien("Gorp", Ganymede, false, 15);
        Alien alienTwo = new Alien("Plak", Pluto, false, 15);
        Alien alienThree = new Alien("Merk", Mercury, false, 15);
        Alien alienFour = new Alien("Queen", Mars, true, 15);

        //Adding aliens to planets solid ones 
        Ganymede.getInfested(alienOne);
        Pluto.getInfested(alienTwo);
        moon.getInfested(alienThree);
        Mars.getInfested(alienFour);

        // START DIALOGE

        System.out.println("What do you wish do?");

        do{
            System.out.println("-----------------------------------------------------------");
            userResponse = userInput.nextLine().toLowerCase(); 


            if (userResponse.contains("look")){
                if (userResponse.contains("left")){
                    System.out.println("To your left is a panel with lots of buttons on it, and a small screen. The screen reads: ");
                    System.out.println("-----------------------------------------------------------");
                    ship.displaySS(); // displays solar system image 
                    System.out.println("");
                    System.out.println("| SPACECRAFT E10.312.01 |"); // random numbers idk 
                    System.out.println("| LOC: Solar System     |");
                    System.out.println("| January 11th, 2036    |");
                    System.out.println("| 17:31 UTC             |");
                    ship.getStatus("introSequence"); 
                }

                else if (userResponse.contains("right")){
                    System.out.println("To your right is a shelf, filled with books. On the top shelf is a picture frame containing a picture of a small child holding a cat.");
                }

                else if (userResponse.contains("backward") || userResponse.contains("behind")){
                    System.out.println("Behind you is a metal room. Nothing too fancy, and certainly nothing too interesting.");
                }

                else if (userResponse.contains("up")){
                    System.out.println("Above you is a metallic ceiling. Not much interesting is going on here.");
                }

                else if (userResponse.contains("down")){
                    System.out.println("Below you is what appears to be a control panel. A simple joystick sits before you. Next to the joystick is a red button with the words 'EJECT'. ");
                    System.out.println("It looks like you could move the joystick.");
                }
                
                else{
                    System.out.println("I don't understand, where do you want to look?");
                }
            }

            else if (userResponse.contains("examine")){

                if (userResponse.contains("panel")){
                    System.out.println("There isn't much else going on with the panel.");
                }

                else if (userResponse.contains("book")){
                    System.out.println("The books are written mostly in a script you cannot understand. Some have pictures, but most are just blocks of unfamilair text.");
                    System.out.println("One book appears to be written in a language you can understand");
                    System.out.println("The title reads: On the Habitability of Jupiter's Moons");
                }

                else if (userResponse.contains("photo") || userResponse.contains("picture")){
                    System.out.println("The photo is old, but in pristine condition.");
                    System.out.println("The child looks a little familiar.");
                }

                else if (userResponse.contains("wall")){
                    System.out.println("The walls are a plain gray metal.");
                    System.out.println("A map of the solar system is taped to the wall, with a child-like star sticker stuck half-way between Saturn and Jupiter.");
                }

                else if (userResponse.contains("screen")){
                    System.out.println("There isn't much else going on with the screen.");
                    System.out.println("Looking at it too close makes your eyes burn, a bit.");
                }

                else{
                    System.out.println("I don't understand. What do you want to examine?");
                }

            }

            else if (userResponse.contains("eject") || userResponse.contains("button") || userResponse.contains("press")){
                System.out.println("You hit the EJECT button once, twice, three times, but nothing happens. It doesn't seem to work.");
            }

            else if (userResponse.contains("move") && userResponse.contains("joystick")){
                Earth.display(); 
                try { 
                System.out.println("You move the joystick, and you feel the ship jerk to the side. ");
                Thread.sleep(1);  
                System.out.println("Suddenly, the dark expanse before you is interrupted by a familiar sight");
                Thread.sleep(1);  
                System.out.println("A large blue and green body, not unlike images of Earth that you have seen before, sits still before you.");
                Thread.sleep(1);  
                System.out.println("Except unlike those images, there appears to be a massive hole through the middle.");
                Thread.sleep(1);  
                System.out.println("");
                introSequence = false; 
                } catch (InterruptedException e) {}

            } 

            else if(!userResponse.contains("look") && !userResponse.contains("move") && !userResponse.contains("examine") && !userResponse.contains("joystick")){
            System.out.println("I don't know what you mean. Try to 'look,' 'move,' or 'examine'");
            }

        } while (introSequence); 

        System.out.println("A chill runs down your spine. How did this happen? When did this happen? What did this?");
        System.out.println("and most importantly... How long have you been unconcious?");
        System.out.println("");
        System.out.println("What do you do? Where do you go?");
        System.out.println("");
        System.out.println("OPTIONS:\n + Go to [body name] \n + Land on [body name]");

        do { 
            
            System.out.println("-----------------------------------------------------------");
            userResponse = userInput.nextLine().toLowerCase(); 
            
            if (userResponse.contains("go")){

                boolean goSuccess = true;

                if (userResponse.contains("mars")){
                    ship.go(Mars);
                }

                else if (userResponse.contains("mercury")){
                    ship.go(Mercury);
                }

                else if (userResponse.contains("venus")){
                    ship.go(Venus);
                }

                else if (userResponse.contains("earth")){
                    System.out.println("As you approach Earth, the Moon comes into view");
                    ship.go(Earth);
                }

                else if (userResponse.contains("jupiter")){
                    ship.go(Jupiter);
                    System.out.println("As you approach Jupiter, two moons - Ganymede and Europa - come into view.");
                    System.out.println("");
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

                else if(userResponse.contains("pluto")){
                    ship.go(Pluto);
                } 

                else if (!ship.location.name.equals("Jupiter") || !ship.location.name.equals("Europa") || !ship.location.name.equals("Ganymede")){
                    if(userResponse.contains("ganymede") || userResponse.contains("europa")){
                        goSuccess = false;
                        System.out.println("You must be in orbit around the host planet before landing on a moon.");
                        System.out.println("");
                    }
                } 

                if (!ship.location.inhabitants.isEmpty() && goSuccess){ 
                    System.out.println("");
                    System.out.println("While you orbit the body, something on the surface appears to be moving...");
                    System.out.println("");
                }
            }

            // if orbiting Jupiter, can land on moons 
            if (userResponse.contains("go") && ship.location.name.equals("Jupiter") && userResponse.toLowerCase().contains("ganymede")){
                if(ship.location.name.equals("Jupiter") || ship.location.name.equals("Europa")){
                    ship.go(Ganymede);
                }
            }

            if (userResponse.contains("go") && userResponse.toLowerCase().contains("europa")){
                if(ship.location.name.equals("Jupiter") || ship.location.name.equals("Ganymede")){
                    ship.go(Europa);
                }
            }

            if (userResponse.contains("land") && ship.location.name.equals("Jupiter") && userResponse.toLowerCase().contains("ganymede")){
                ship.land(Ganymede); 
            }

            if (userResponse.contains("land") && ship.location.name.equals("Jupiter") && userResponse.toLowerCase().contains("europa")){
                ship.land(Europa); 
            }

            // if orbiting Earth, can go to and land on the moon
            if  (userResponse.contains("go") && ship.location.name.equals("Earth") && userResponse.contains("moon")){
                ship.go(moon);
            }

            if  (userResponse.contains("land") && ship.location.name.equals("Earth") && userResponse.contains("moon")){
                ship.land(moon);
            }

            if (userResponse.toLowerCase().contains("land") && !userResponse.toLowerCase().contains(ship.location.name.toLowerCase())){
                System.out.println("You can't land on a planet you aren't orbiting. Try going there first!");
            }

            if (userResponse.toLowerCase().contains("land") && userResponse.toLowerCase().contains(ship.location.name.toLowerCase())){                
                
                landSuccess = false; 
                System.out.println("You engage your landing gears and begain your descent towards " + ship.location.name + ".");
                System.out.println("");

                if (ship.location.surface == surfaceProperties.gas){ // you cannot land on a gas giant 
                    System.out.println("As you descend towards " + ship.location.name + ", the air grows dense and hazy, and you feel a stong graviational pull.");
                    System.out.println("The walls around you begin to cave in as the outside haze closes in.");
                    System.out.println("You feel crushed under the extreme gravity as the ship's power begins to fade...");
                    System.out.println("");
                    //  endgameSequence = true;   // rip 
                    user.die(); 
                    midgameSequence = false; 
                    landSuccess = false; 

                }

                else if (ship.location.surface == surfaceProperties.ice){
                    System.out.println("As you descend towards " + ship.location.name + ", you don't notice much difference from the stark, interplanetary air. There is little atmosphere, and the surface is glistening in reflected light.");
                    ship.land(ship.location);
                    landSuccess=true; 
                }

                else if (ship.location.surface == surfaceProperties.rock){
                    System.out.println("As you descend towards " + ship.location.name + ", a thin, teneous atmosphere becomes visible. The surface appears rocky and cratered. ");
                    System.out.println("");
                    if (!ship.location.destroyed){
                        ship.land(ship.location);
                        if (!ship.location.inhabitants.isEmpty()){
                            System.out.println("As you descend, you see the thing on the surface is a massive, earthworm-like...thing.");
                            System.out.println("It appears to have burrowed through the surface of the body... and as you land, its head surfaces right by your ship.");
                            System.out.println("");
                        }
                        landSuccess=true;
                    } else{
                        System.out.println("The surface seems too damaged to land...");
                        System.out.println("");
                    }
                }
                
                if (midgameSequence && landSuccess){

                System.out.println("");
                System.out.println("OPTIONS: \n + Unboard \n + Board \n + Talk \n + Fight \n + Take off");
                if (ship.location.name.equals("Europa")){
                    System.out.println(" + examine [object] \n + open [object]"); // different options on europa 
                }

                do { 

                    Alien localLife = new Alien("bacteria", ship.location, false, 2);  // default local life 
                    if (!ship.location.inhabitants.isEmpty()){  // if a worm is there reassign local life to the worm 
                        localLife = ship.location.inhabitants.get(0);
                    }
        
                    // System.out.println("What do you wish do?");
                    System.out.println("-----------------------------------------------------------");
                    userResponse = userInput.nextLine().toLowerCase();

                    if (userResponse.contains("board") && !userResponse.contains("un")){
                        if (user.onBoard){
                            System.out.println("You are already on board.");
                        }  else {
                            ship.board(user);
                            System.out.println("Would you like to take off again (y/n)?");
                            String userResponseTakeOff = userInput.nextLine().toLowerCase();
                            if(userResponseTakeOff.toLowerCase().contains("y")){
                                ship.takeOff(ship.location);
                                landSuccess  = false;
                            } 
                        }
                    }

                    if (userResponse.contains("unboard") && !userResponse.contains(" board")){
                        if (!user.onBoard){
                            System.out.println("You are already outside your ship.");
                        } 
                        else{
                            ship.unboard(user);
                            System.out.println("You are now on the surface of " + ship.location.name);
                            if (!ship.location.inhabitants.isEmpty()){
                                System.out.println("You land, and see the being surface near you.");
                                System.out.println("You turn to see what looks like... the head of a giant earthworm?");
                                System.out.println("Do you want to fight it, talk to it, or get back onboard?");
                                System.out.println("");
                            } else if (!ship.location.equals(Europa)){
                                System.out.println("No matter where you look, there's no signs of life.");
                            }
                        }
                    }

                    if (userResponse.contains("take off")){
                        if (!user.onBoard){
                            System.out.println("You can't take off from outside the ship!");
                        } else{
                            ship.takeOff(ship.location);
                            landSuccess=false; 
                        }
                    }
                            

                    if (ship.location.name.equals("Europa") && (userResponse.toLowerCase().trim().contains("door") || userResponse.toLowerCase().trim().contains("silver"))){
                        System.out.println("You walk towards the silver thing in the distance. As you get closer, you see a door, protruding from the ice.");
                        System.out.println("-----------------------------------------------------------");
                        userResponse = userInput.nextLine().toLowerCase(); 

                        if (user.knowsCode){
                            System.out.println("Wait! you have a key!");
                            System.out.println("-----------------------------------------------------------");
                            userResponse = userInput.nextLine().toLowerCase(); 

                            if (userResponse.toLowerCase().trim().contains("open") && user.knowsCode){
                                System.out.println("You insert the key into the hole, and turn the knob.");
                                System.out.println("The door opens to reveal a staircase, leading down.");
                                System.out.println("You descend the stairs, and after quite some time, come to an elevator.");
                                System.out.println("You enter the elevator, and press the only button there.");
                                System.out.println("'going down!'");
                                System.out.println("...");
                                System.out.println("After some time, the elevator opens to a room."); // idk what ending should be but here it is
                                midgameSequence = false;   

                            } 
                        } 
                            //End of game stuff
                        
                        else if (!user.knowsCode){
                            System.out.println("Suprise, suprise. the door is locked.");
                            System.out.println("Maybe the key is somewhere...");
                            System.out.println("The solar system isn't that big, right?");
                        }
                        
                    }

                    if (userResponse.contains("fight") || userResponse.contains("attack")){
                        
                        if(user.onBoard || localLife.name.equals("bacteria")){
                            System.out.println("What are you going to fight? The ground?");
                        } 
                        
                        else if (localLife.alive) {

                            if (localLife.hitpoints <= 0){
                                localLife.alive = false;
                            }

                            if (localLife.alive){
                                user.attack(localLife);
                                if (!user.alive){
                                    midgameSequence = false; 
                                    System.out.println("The alien strikes you, and it really hurts... you collapse to the ground!");
                                } 
                            } 
                                
                            if (user.alive && !localLife.alive && !localLife.hasKey){
                                System.out.println("The earthworm-like being lets out a shrill cry, and then, almost like a projection, dissapates.");
                                System.out.println("...");
                                System.out.println("Well, that was weird.");
                            } else if (!localLife.alive && localLife.hasKey){ // if has the key, 
                                System.out.println("The earthworm crumbles to the ground, flickers once, and then gets back up.");
                                System.out.println(localLife.textColor +localLife.name + ": Now Human, let's not fight. How about a conversation?" + User.textReset);
                            }
                        } 
                        
                        else if (!localLife.alive){
                            if (localLife.hasKey){
                                System.out.println(localLife.textColor +localLife.name +  ": Didn't you hear me? Let's not fight." + User.textReset);
                            } else{
                                System.out.println("It's already gone!");
                            }
                        }
                    }   
                    

                    if (userResponse.contains("talk")){
                        if (user.onBoard || localLife.name.equals("bacteria") || !localLife.alive){
                            System.out.println("I know times are tough, but talking to the air is a step too far.");
                        } 
                        else if (!localLife.hasKey){ // does not have key talk
                            localLife.alienTalk(); 
                        }
                        else if (localLife.hasKey){
                            System.out.println("What do you want to say? ");
                            String userTalk = userInput.nextLine().toLowerCase(); 
                            user.userTalk(localLife, userTalk); 
                        }
                    }

                    if ((userResponse.contains("status"))){
                        if (user.onBoard){
                            ship.getStatus("onBody");
                        } else{
                            System.out.println("You can't check the status when you're not on the ship!");
                        }
                    }

                    else if(!userResponse.contains("status") && !userResponse.contains("talk") && !userResponse.contains("fight") && !userResponse.contains("attack") &&  !userResponse.contains("board") &&  !userResponse.contains("examine") && !userResponse.contains("open") && !userResponse.contains("take") && !userResponse.contains("door") && !userResponse.contains("silver")){
                        System.out.println("I don't know what you mean. Try 'talk', 'fight', 'take off, 'board/unboard', 'take off'");
                    }

                } while (landSuccess && midgameSequence); 
                }
            }

            if ((userResponse.contains("status"))){
                ship.getStatus("orbitSequence"); // get status at any time 
            }

            if(!userResponse.contains("status") && !userResponse.contains("land") && !userResponse.contains("go") && !userResponse.contains("board") && !userResponse.contains("open") && !userResponse.contains("take off")){
                System.out.println("I don't know what you mean. ");  //This prints when user dies in fight — how to fix?
                System.out.println("");
            }

        } while (midgameSequence);
            
        if (user.alive){
            try{
                Thread.sleep(1000); 
                System.out.println("...");
                Thread.sleep(1000); 
                System.out.println("SUPRISE!");
                Thread.sleep(1000); 
                System.out.println("you stand in shock as your friends and family cheer for you. There is a large cake on the table.");
                Thread.sleep(2000); 
                System.out.println("You look down, and see you are wearing solar system print pajamas. A cat rubs against your leg.");
                Thread.sleep(2000); 
                System.out.println("Well. That was a weird dream, you think.");
                } catch (InterruptedException e) {}
        }

        else {
            try{
            System.out.println("You wake up in a cold sweat... in your childhood bedroom? ");
            Thread.sleep(1000);
            System.out.println("The clock reads 3:14 AM.");
            Thread.sleep(1000);
            System.out.println("You should go back to sleep.");
            } catch (InterruptedException e) {}
        }
    }
}

