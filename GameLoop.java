import java.util.Scanner;

public class GameLoop {

    //Unique attributes of the game loop
    //Booleans program know what part of the game we are in
    boolean introSequence;
    boolean midgameSequence;
    boolean landSuccess;

    public static void main(String[] args) {

        // Initialize booleans to let program know we are in the intro sequence
        boolean introSequence = true;
        boolean midgameSequence = true;
        boolean landSuccess = false;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        System.out.println(User.textReset); //Reset text color to the default, to avoid issues when game is played multiple times

        //Print intro statement
        try{
            System.out.println("...");
            Thread.sleep(500); //Wait .5 seconds between printing each line
            System.out.println("The air is extremly still.");
            Thread.sleep(1000);
            System.out.println("Before you is a dark expanse. Metallic walls surround you.");
            Thread.sleep(2000);
            System.out.println("You have no idea where you are."); 
            Thread.sleep(2000);
            System.out.println("");
            System.out.println("OPTIONS: \n + Look [up/left/right/down/backwards] \n + Examine [object] \n + Move [object]"); //Print the things the user can do
        } catch (InterruptedException e) {}

        // initilizing other planets + moons 
        celestialBody Mercury = new celestialBody("Mercury", 0.387, false, "small, rocky and gray. Heavily cratered and having a very thin exosphere.", surfaceProperties.rock, false);
        celestialBody Venus = new celestialBody("Venus", 0.723, false, "hot and turbulant. Below the thick clouds is a cratered surface eeriely resembling Earth's, but over 600 degrees warmer.", surfaceProperties.rock, false);
        celestialBody Mars = new celestialBody("Mars", 1.52, false, "red and dusty. Rocks and craters are abundant", surfaceProperties.rock, false);
        celestialBody Earth = new celestialBody("Earth", 1., true, "blue and green, with a gaping hole through the center.",  surfaceProperties.rock, true); 
        Moon moon = new Moon("Earth's moon", 0.00257, false, "rocky and gray, with a stark view of the crumbling Earth on the horizon.", surfaceProperties.rock, Earth);
        celestialBody Jupiter = new celestialBody("Jupiter", 5.2, false, "massive and made entierly of swirling gas. Stratified cloud decks, and an angry, swirling red spot. \nTwo icy moons, Ganymede and Europa, come into view.", surfaceProperties.gas, true);
        Moon Europa = new Moon("Europa", 0.0042, false, "cold and icy, with deep red chasams. Something silvery juts out from the ground near your ship. \nYou can almost make out the shape of a door?", surfaceProperties.ice, Jupiter); 
        Moon Ganymede = new Moon("Ganymede", 0.007155, false, "massive, yet small relative to Jupiter. The surface appears icy and bland.", surfaceProperties.ice, Jupiter); 
        celestialBody Saturn = new celestialBody("Saturn", 9.5, false, "delicate and ringed. Almost uniform in a golden beige color, and surrounded by majestic, rocky debris. ",  surfaceProperties.gas, false);
        celestialBody Uranus = new celestialBody("Uranus", 19.19, false, "a light blue hue, hosting thin, teneous rings. The rings appears almost tilted on their side!",  surfaceProperties.gas, false);
        celestialBody Neptune = new celestialBody("Neptune", 30., false, "a distant and deep blue. A small, dark blue spot peers back at you." ,  surfaceProperties.gas, false);
        celestialBody Pluto = new celestialBody("Pluto", 39.5, false, "small and desolate. A small red heart appears on its side." ,  surfaceProperties.rock, false);

        //Adding moons to host planets
        Jupiter.addMoon(Europa);
        Jupiter.addMoon(Ganymede); 
        Earth.addMoon(moon);

        // initilizing user, ship
        spaceShip ship = new spaceShip(100, Earth); 
        User user = new User(Earth, 30); 

        //initializing aliens
        Alien alienOne = new Alien("Gorp", Ganymede, false, 15);
        Alien alienTwo = new Alien("Plak", Pluto, false, 15);
        Alien alienThree = new Alien("Merk", Mercury, false, 15);
        Alien alienFour = new Alien("Queen", Mars, true, 15);

        //Adding aliens to planets
        Ganymede.getInfested(alienOne);
        Pluto.getInfested(alienTwo);
        moon.getInfested(alienThree);
        Mars.getInfested(alienFour);

        // START OF GAMEPLAY

        System.out.println("What do you wish do?"); //Prompts user for input

        do{
            System.out.println("-----------------------------------------------------------");
            userResponse = userInput.nextLine().toLowerCase(); //Takes in user input as lowercase, to avoid issues with capitals

            if (userResponse.contains("look")){ //If user response contains the word "look"

                if (userResponse.contains("left")){ //Print information about panel to the left
                    System.out.println("To your left is a panel with lots of buttons on it, and a small screen. The screen reads: ");
                    System.out.println("-----------------------------------------------------------");
                    ship.displaySS(); // displays solar system image 
                    System.out.println("");
                    // Random lines for immersion/sci fi ephemera
                    System.out.println("| SPACECRAFT E10.312.01 |"); 
                    System.out.println("| LOC: Solar System     |"); 
                    System.out.println("| January 11th, 2036    |"); 
                    System.out.println("| 17:31 UTC             |");
                    ship.getStatus("introSequence"); //Options the user can do
                }

                else if (userResponse.contains("right")){ //Print information about bookshelf to the right
                    System.out.println("To your right is a shelf, filled with books. On the top shelf is a picture frame containing a picture of a small child holding a cat.");
                }

                else if (userResponse.contains("backward") || userResponse.contains("behind")){ //Information about room behind the user
                    System.out.println("Behind you is a metal room. Nothing too fancy, and certainly nothing too interesting.");
                }

                else if (userResponse.contains("up")){ //Print information about ceiling above the user
                    System.out.println("Above you is a metallic ceiling. Not much interesting is going on here.");
                }

                else if (userResponse.contains("down")){ // Print information about panel and joystick below the user
                    System.out.println("Below you is what appears to be a control panel. A simple joystick sits before you. Next to the joystick is a red button with the words 'EJECT'. ");
                    System.out.println("It looks like you could move the joystick."); //Nudge forward in gameplay
                }
                
                else{ //If the user doesn't look in any default direction
                    System.out.println("I don't understand, where do you want to look?"); //Prompt them to put in an answer the loop will understand
                }
            }

            else if (userResponse.contains("examine")){ //If the user says they want to examine something

                if (userResponse.contains("panel")){ //Print information about panel
                    System.out.println("There isn't much else going on with the panel.");
                }

                else if (userResponse.contains("book")){ //Print information about the books
                    System.out.println("The books are written mostly in a script you cannot understand. Some have pictures, but most are just blocks of unfamilair text.");
                    System.out.println("One book appears to be written in a language you can understand");
                    System.out.println("The title reads: On the Habitability of Jupiter's Moons"); //Hint for Europa
                }

                else if (userResponse.contains("photo") || userResponse.contains("picture")){ //Print information about the photo
                    System.out.println("The photo is old, but in pristine condition.");
                    System.out.println("The child looks a little familiar."); // Hint about waking up in a childhood bedroom
                }

                else if (userResponse.contains("wall")){ //Print information about the wall
                    System.out.println("The walls are a plain gray metal.");
                    System.out.println("A map of the solar system is taped to the wall, with a childish star sticker stuck half-way between Saturn and Jupiter."); //Hint for Europa
                }

                else if (userResponse.contains("screen")){ //Print information about the screen
                    System.out.println("There isn't much else going on with the screen.");
                    System.out.println("Looking at it too close makes your eyes burn, a bit.");
                }

                else{ //If user asks to examine something we don't have a description for
                    System.out.println("I don't understand. What do you want to examine?"); //Prompt them to clarify/examine something diff
                }

            }

            else if (userResponse.contains("eject") || userResponse.contains("button") || userResponse.contains("press")){ //If user tries to hit the eject button
                System.out.println("You hit the EJECT button once, twice, three times, but nothing happens. It doesn't seem to work."); //Don't let them die — sorry!
            }

            else if (userResponse.contains("move") && userResponse.contains("joystick")){ //If user inputs that they want to move the joystick
                Earth.display(); //Print ASCII picture of earth
                try { 
                    System.out.println("You move the joystick, and you feel the ship jerk to the side. ");
                    Thread.sleep(500); //Thread.sleep delays the printing of each line
                    System.out.println("Suddenly, the dark expanse before you is interrupted by a familiar sight");
                    Thread.sleep(1000); 
                    System.out.println("A large blue and green body, not unlike images of Earth that you have seen before, sits still before you.");
                    Thread.sleep(1500);  
                    System.out.println("Except unlike those images, there appears to be a massive hole through the middle.");
                    Thread.sleep(2000);  
                    System.out.println("");
                    introSequence = false; //Set intro to false, move into the middle sequence of the game
                } catch (InterruptedException e) {}

            } 
            
            //If user input asks to do something the game doesn't support, tell them to do something we have accounted for
            else if(!userResponse.contains("look") && !userResponse.contains("move") && !userResponse.contains("examine") && !userResponse.contains("joystick")){
            System.out.println("I don't know what you mean. Try to 'look,' 'move,' or 'examine'");
            }

        } while (introSequence); //Do all of the above while the user has yet to move the joystick/while in the introduction to the game

        //Text transitioning user from intro to mid-game sequences
        System.out.println("A chill runs down your spine. How did this happen? When did this happen? What did this?");
        System.out.println("and most importantly... How long have you been unconcious?");
        System.out.println("");
        System.out.println("What do you do? Where do you go?");
        System.out.println("");
        System.out.println("OPTIONS:\n + Go to [planet/moon name] \n + Land on [planet/moon name]");

        do { // while loop for midgame sequence 
            
            System.out.println("-----------------------------------------------------------");
            userResponse = userInput.nextLine().toLowerCase(); //Take in user input, lower case to avoid issues with capitalization
            
            if (userResponse.contains("go")){ //If user wants to go somewhere
                
                boolean goSuccess = true; //Set boolean of go being successful to true 
                //Because this boolean is almost always true, it's easier to set it it true here and untrue in a few places than untrue here and true everywhere else

                if (ship.fuel <= 3){ // first ensure that the user has enough fuel currently in their tank
                    System.out.println("You comamnd your ship to move, but a flashing message appears on the screen." );
                    System.out.println(Alien.textRed + "LOW FUEL. LOW FUEl. LOW FUEL." + User.textReset);
                    System.out.println("Where the heck are you supposed to get fuel?");
                    user.die(); 
                    midgameSequence = false; 
                    goSuccess = false;
                }
                
                //Go to celestial body the user specifies
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
                    System.out.println("As you approach Earth, the Moon comes into view"); //Print that Earth has a moon
                    ship.go(Earth);
                }

                else if (userResponse.contains("jupiter")){
                    ship.go(Jupiter);
                    System.out.println("As you approach Jupiter, two moons - Ganymede and Europa - come into view."); //Print that Jupiter has two moons you can land on (IRL it has many, many more)
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

                //Because Ganymede, Europa, and the moon are moons, the user can't land on it unless they're already at the host planet
                else if (userResponse.contains("ganymede")){
                    if (ship.location.name.equals("Jupiter") || ship.location.name.equals("Europa")){ //Check if user is at Jupiter or Europa
                        ship.go(Ganymede); 
                    } else{  //Go failed, tell user of their logical error
                        goSuccess = false;
                        System.out.println("You must be in orbit around the host planet before landing on a moon.");
                    }
                } 

                else if (userResponse.contains("europa")){
                    if (ship.location.name.equals("Jupiter") || ship.location.name.equals("Ganymede")){ //Check ifuser is at Jupiter or Ganymede
                        ship.go(Europa);
                    } else{  //Go failed, tell user of their logical error
                        goSuccess = false;
                        System.out.println("You must be in orbit around the host planet before landing on a moon.");
                    }
                }

                else if (userResponse.contains("moon")){
                    if (ship.location.name.equals("Earth")){ //Check ifuser is at the Earth
                        ship.go(moon);
                    } else{  //Go failed, tell user of their logical error
                        goSuccess = false;
                        System.out.println("You must be in orbit around the host planet before landing on a moon.");
                    }
                }

                else if (userResponse.contains("sun")){ //Handle if someone wants to go to the sun
                    System.out.println("As you approach the Sun, your ship suddenly stops.");
                    System.out.println("A bright red message pops up on the panel to your left:");
                    System.out.println(Alien.textRed + "TEMPERATURE TOO HIGH. CANNOT APPROACH." + User.textReset);
                    ship.go(Mercury);
                    System.out.println("This is as far as you can go, it seems. Mercury it is."); //Keep people playing the game and on-task 
                }

                //If the planet the user went to has aliens on it, print a hint about this
                if (!ship.location.inhabitants.isEmpty() && goSuccess){ 
                    System.out.println("");
                    System.out.println("While you orbit the body, something on the surface appears to be moving...");
                }
            }

            //If user tries to land on a planet they aren't near, print their logical error
            if (userResponse.contains("land") && !userResponse.contains(ship.location.name.toLowerCase())){
                //Catch if they are trying to land on a moon
                if  (userResponse.contains("land") && ship.location.name.equals("Earth") && userResponse.contains("moon")){
                    ship.land(moon);
                } else if (userResponse.contains("land") && ship.location.name.equals("Jupiter") && userResponse.toLowerCase().contains("ganymede")){
                    ship.land(Ganymede); 
                } else if (userResponse.contains("land") && ship.location.name.equals("Jupiter") && userResponse.toLowerCase().contains("europa")){
                    ship.land(Europa); 
                } else{ //If not, print logical error
                    System.out.println("You can't land on a planet you aren't orbiting. Try going there first, or specifying a planet/moon!");
                }
            }

            //If user inputs to land on the planet they are orbiting,
            if (userResponse.contains("land") && userResponse.contains(ship.location.name.toLowerCase())){                
                
                landSuccess = false; //Set landsuccess to false
                System.out.println("You engage your landing gears and begain your descent towards " + ship.location.name + ".");

                if (ship.location.surface == surfaceProperties.gas){ // You cannot land on a gas giant 
                    System.out.println("As you descend towards " + ship.location.name + ", the air grows dense and hazy, and you feel a stong graviational pull.");
                    System.out.println("The walls around you begin to cave in as the outside haze closes in.");
                    System.out.println("You feel crushed under the extreme gravity as the ship's power begins to fade...");
                    System.out.println("");
                    user.die(); //User dies
                    midgameSequence = false; //Mid-game ends

                }

                else if (ship.location.surface == surfaceProperties.ice){ //You can land on an icy planet!
                    System.out.println("As you descend towards " + ship.location.name + ", you don't notice much difference from the stark, interplanetary air. There is little atmosphere, and the surface is glistening in reflected light.");
                    ship.land(ship.location); //Successfully land on planet
                    landSuccess=true; 
                }

                else if (ship.location.surface == surfaceProperties.rock){ //You can land on a rock planet!
                    System.out.println("As you descend towards " + ship.location.name + ", a thin, teneous atmosphere becomes visible. The surface appears rocky and cratered. ");
                    if (!ship.location.destroyed){ //If place is NOT destroyed,
                        ship.land(ship.location); //Landing is possible!
                        if (!ship.location.inhabitants.isEmpty()){ //Print that alien is right outside ship
                            System.out.println("As you descend, you see the thing on the surface is a massive, earthworm-like...thing.");
                            System.out.println("It appears to have burrowed through the surface of the body... and as you land, its head surfaces right by your ship.");
                        }
                        landSuccess=true; //Successfuly land
                    } else{
                        System.out.println("The surface seems too damaged to land..."); //Do not land
                        System.out.println("");
                    }
                }
                
                    if (midgameSequence && landSuccess){ //When landing is successful, we move into a new phase of the ground

                        System.out.println("");
                        System.out.println("OPTIONS: \n + Unboard \n + Board \n + Talk \n + Fight \n + Take off"); //Print options
                        if (ship.location.name.equals("Europa")){
                            System.out.println(" + Examine [object] \n + Open [object]"); // different options on europa 
                        }

                        do { 

                            Alien localLife = new Alien("bacteria", ship.location, false, 2);  // default local life, can't fight/talk to,
                            if (!ship.location.inhabitants.isEmpty()){  // if a worm is there reassign local life to the worm 
                                localLife = ship.location.inhabitants.get(0);
                            }
                
                            System.out.println("-----------------------------------------------------------");
                            userResponse = userInput.nextLine().toLowerCase(); //Take in user input

                            if (userResponse.contains("board") && !userResponse.contains("un")){ //If user wants to board (and doesn't want to UNboard)
                                if (user.onBoard){
                                    System.out.println("You are already on board."); //Cannot board if already on the ship
                                }  else {
                                    ship.board(user); //Board user
                                    System.out.println("Would you like to take off again (y/n)?"); //Ask if user wants to go back to outer space
                                    String userResponseTakeOff = userInput.nextLine().toLowerCase(); //Take in user input
                                    if(userResponseTakeOff.toLowerCase().contains("y")){ //If user says yes or y take off again
                                        ship.takeOff(ship.location);
                                        landSuccess  = false; //set landSuccess to false brings back to do/while loop in outer space, rather than on planet
                                    } 
                                }
                            }

                            if (userResponse.contains("unboard") && !userResponse.contains(" board")){ //If user wants to unboard
                                if (!user.onBoard){
                                    System.out.println("You are already outside your ship."); //Can't unboard if already not on ship
                                } else{
                                    ship.unboard(user); //Unboard user
                                    System.out.println("You are now on the surface of " + ship.location.name); //Print location
                                    if (!ship.location.inhabitants.isEmpty()){ //If worm aliens are on planet print that they are there
                                        System.out.println("You land, and see the being surface near you.");
                                        System.out.println("You turn to see what looks like... the head of a giant earthworm?");
                                        System.out.println("Do you want to fight it, talk to it, or get back onboard?");
                                    } else if (!ship.location.equals(Europa)){ //If not on Europa and no aliens on the ship, print message that there is nothing here
                                        System.out.println("No matter where you look, there's no signs of life.");
                                    }
                                }
                            }

                            if (userResponse.contains("take off")){ //If user wants to take off
                                if (!user.onBoard){ //Can't take off without being on board
                                    System.out.println("You can't take off from outside the ship!");
                                } else{
                                    ship.takeOff(ship.location);
                                    landSuccess=false; //set landSuccess to false brings back to do/while loop in outer space, rather than on planet
                                }
                            }
                                    

                            if (ship.location.name.equals("Europa") && (userResponse.contains("door") || userResponse.contains("silver"))){ //If user is on Europa, they can open/examine the door
                                System.out.println("You walk towards the silver thing in the distance. As you get closer, you see a door, protruding from the ice.");

                                if (user.hasKey){ //If the user has a key, let them open it
                                    System.out.println("Wait! you have a key!"); 
                                    System.out.println("-----------------------------------------------------------");
                                    userResponse = userInput.nextLine().toLowerCase(); 

                                    if (userResponse.contains("open")){ //if the user asks to open it, open up the door
                                        try{
                                        System.out.println("You insert the key into the hole, and turn the knob.");
                                        System.out.println("The door opens to reveal a staircase, leading down.");
                                        System.out.println("You descend the stairs, and after quite some time, come to an elevator.");
                                        System.out.println("You enter the elevator, and press the only button there.");
                                        System.out.println("'going down!'");
                                        System.out.println("...");
                                        Thread.sleep(3000); // pause for 3s to read 
                                        System.out.println("After some time, the elevator opens to a room."); 
                                        } catch (InterruptedException e) {}
                                        
                                        midgameSequence = false; //Midgame sequence = false brings user to the end of the game

                                    } 
                                } 
                                
                                else if (!user.hasKey){ //If user doesn't have the key, print that they can't open the door
                                    System.out.println("The door is metal and sturdy.");
                                    System.out.println("Just for good measure, you try the handle.");
                                    System.out.println("But suprise, suprise. The door is locked.");
                                    System.out.println("Maybe the key is somewhere...");
                                    System.out.println("The solar system isn't that big, right?");
                                    System.out.println("-----------------------------------------------------------");
                                }
                            }

                            if (userResponse.contains("fight") || userResponse.contains("attack")){ //If user tries to fight or attack
                                
                                if(user.onBoard || ship.location.inhabitants.isEmpty() || !localLife.alive){ //If user is on board or there aren't any aliens, print that there is no one to attack
                                    System.out.println("What are you going to fight? The ground?");
                                } 
                                
                                else if (localLife.alive) { //if the local life is alive, you can fight it!

                                    if (localLife.hitpoints <= 0){ //If local life has fewer than 1 hitpoints, make it die
                                        localLife.alive = false; 
                                    }

                                    if (localLife.alive){ //If local life is alive
                                        user.attack(localLife); //User can actually attack it
                                        if (!user.alive){ //If user is critically hurt, print this
                                            System.out.println("The alien strikes you, and it really hurts... you collapse to the ground!");
                                            midgameSequence = false; //Stop mid-game sequence
                                        } 
                                    } 
                                    
                                    if (user.alive && !localLife.alive && !localLife.hasKey){ //If user kills an alien that does not have the key,
                                        System.out.println("The earthworm-like being lets out a shrill cry, and then, almost like a projection, dissapates."); //Print that the alien dies/dissapears
                                        System.out.println("...");
                                        System.out.println("Well, that was weird.");
                                    } else if (!localLife.alive && localLife.hasKey){ // if the killed alien has the key, print that it gets back up and starts talking to the person
                                        System.out.println("The earthworm crumbles to the ground, flickers once, and then gets back up.");
                                        System.out.println(localLife.textColor + localLife.name + ": Now Human, let's not fight. How about a conversation?" + User.textReset);
                                    }
                                } 
                                
                                else if (!localLife.alive){ // if local life is not alive and the user keeps trying to fight it
                                    if (localLife.hasKey){ //If it has the key, it talks to the user and tells them to stop
                                        System.out.println(localLife.textColor +localLife.name +  ": Didn't you hear me? Let's not fight." + User.textReset);
                                    } else{ //If the alien is fully gone, the game tells the user to try something else
                                        System.out.println("It's already gone!\nThere's no life left around on this planet.");
                                    }
                                }
                            }   

                            if (userResponse.contains("talk")){ //If the user wants to talk
                                if (user.onBoard || ship.location.inhabitants.isEmpty() || !localLife.alive){ //User cannot talk when they are on board or there are no aliens around
                                    System.out.println("I know times are tough, but talking to the air is a step too far.");
                                } else if (!localLife.hasKey){ // When local life does not have the key, 
                                    localLife.alienTalk(); //Print canned responses
                                } else if (localLife.hasKey){ //When local life has the key
                                    System.out.println("What do you want to say? "); //User can input a response
                                    String userTalk = userInput.nextLine().toLowerCase();  //Response is taken in and converted to all lower case to avoid capitalization issues
                                    user.userTalk(localLife, userTalk); //userTalk takes in the input and alien responds
                                    System.out.println("If you want to talk to the alien again, please specify."); //Makes it clear that the user has to say to talk again — issue players had
                                }
                            }

                            if ((userResponse.contains("status"))){ //If the user wants to check the status,
                                if (user.onBoard){ //Check if user on board
                                    ship.getStatus("onBody"); //Print status of the ship
                                } else{ //if user isn't on board, they cannot check the status
                                    System.out.println("You can't check the status when you're not on the ship!");
                                }
                            }

                            //If user says anything else, the game tells them to input a different response
                            else if(!userResponse.contains("status") && !userResponse.contains("talk") && !userResponse.contains("fight") && !userResponse.contains("attack") &&  !userResponse.contains("board") &&  !userResponse.contains("examine") && !userResponse.contains("open") && !userResponse.contains("take") && !userResponse.contains("door") && !userResponse.contains("silver")){
                                System.out.println("I don't know what you mean. Try 'talk', 'fight', 'take off, 'board/unboard', 'take off'");
                            }

                        } while (landSuccess && midgameSequence); //Everything in this do/while loop only happens when the user is on a body
                    }
            }

            if ((userResponse.contains("status"))){
                ship.getStatus("orbitSequence"); // get status at any time while on the ship
            }

            //If user inputs something that they can't do, game prints this instead of skipping
            if(!userResponse.contains("status") && !userResponse.contains("land") && !userResponse.contains("go") && !userResponse.contains("board") && !userResponse.contains("open") && !userResponse.contains("take off")){
                System.out.println("I don't know what you mean.");  
            }

        } while (midgameSequence); //All of this do/while loop is the mid-game sequence of the game. When this ends, the game is over
            
        if (user.alive){ //If the game ends and the user is alive, print the following ending:
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
        } else { //If the game ends and the user is not alive, pring the following ending:
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
