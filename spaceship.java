class spaceship{
    
    static int rations;
    int fuel;
    Number orbitalDistance;

    public spaceship(int rations, int fuel){
        this.rations = rations;
        this.fuel = fuel;
        this.orbitalDistance = 1;
    }

    private void board(User user){ //make possible for aliens?
        if(user.onBoard){ 
            System.out.println("You are already on this ship and cannot board.");
        } else{
            user.onBoard = true;
            System.out.println("Welcome aboard!");
        }
    }

    private void unboard(User user){
        if(user.onBoard){
            user.onBoard = false;
            System.out.println("Now unboarding...");
        } else{
            System.out.println("You can't unboard a ship you're not on!");
        }
    }

    public void go(celestialBody bodyName){
        //Math for going/fuel level here :)
        //If the ship has enough fuel to go there,
            //change orbitalDistance to celestial body's
            //print that you are now there
            //Change fuel level by difference between ship's orbitalDistance and body's orbitalDistance
            //print fuel level?
        //Else,
            //Print that there is not enough fuel to go there
        
    }

    public void land(celestialBody bodyName){
        if (this.orbitalDistance == bodyName.orbitalRadius){
            System.out.println("Landing on " + bodyName + "...");
            System.out.println("Welcome to " + bodyName + "!");
            this.fuel -= 1;
        } else{
            System.out.println("You cannot land on a body you are not near! Go to this body before you land.");
        }
    }

    public void takeOff(celestialBody bodyName){
        if (this.orbitalDistance == bodyName.orbitalRadius){
            System.out.println("Leaving " + bodyName + "...");
            System.out.println("Welcome to space!");
            this.fuel -= 1;
        } else{
            System.out.println("You are not on this body and cannot take off from it.");
        }
    }

    public String status(){
        return "CURRENT STATUS: \n + Fuel = " + this.fuel + "\n + Rations = " + this.rations;
    }
}