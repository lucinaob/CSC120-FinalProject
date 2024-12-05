class spaceShip{
    
    static int rations;
    double fuel;
 //   double orbitalDistance;
    celestialBody location; 

    public spaceShip(int rations, double fuel, celestialBody location){
        this.rations = rations;
        this.fuel = fuel;
        this.location = location;
    }

    public void board(User user){ 
        if(user.onBoard){ 
            System.out.println("You are already on this ship and cannot board.");
        } else{
            user.onBoard = true;
            System.out.println("Welcome aboard!");
        }
    }

    public void unboard(User user){
        if(!user.onBoard){
            System.out.println("You can't unboard a ship you're not on!");
        } else{
            user.onBoard = false;
            System.out.println("Now unboarding...");
        }
    }

    public void go(celestialBody bodyName){
        double distance = Math.abs(bodyName.orbitalRadius - this.location.orbitalRadius);
        if (fuel < distance){
            System.out.println("You don't have enough fuel to go here!");
        } else{
            if(distance == 0){
                System.out.println("You are already here!");
            } else{
                fuel -= distance;
                this.location = bodyName;
                System.out.println("You are now in orbit about " + bodyName.name + "."); 
            }
        }
        
    }

    public boolean land(celestialBody bodyName){
        if (this.location.orbitalRadius == bodyName.orbitalRadius){ // same location 
            System.out.println("Landing on " + bodyName.name + "..."); //bodyname doesn't work?
            System.out.println("Welcome to " + bodyName.name + "!");
            System.out.println(bodyName.name + " appears " + bodyName.description); // print what you see 
            this.fuel -= 1;
            return true;
        } else{
            System.out.println("You cannot land on a body you are not near! Go to this body before you land.");
            return false;
        }
    }

    public void takeOff(celestialBody bodyName){
        if (this.location.orbitalRadius == bodyName.orbitalRadius){
            System.out.println("Taking off from " + bodyName.name + "..."); //bodyname doens't work?
            System.out.println("You are now in orbit about " + bodyName.name + ".");
            this.fuel -= 1;
        } else{
            System.out.println("You are not on this body and cannot take off from it.");
        }
    }

    public void getStatus(String place){
        System.out.println("CURRENT STATUS: \n + Fuel = " + this.fuel + "\n + Rations = " + this.rations + "\n + LOCATION: " + this.location.name); 
        if (place.equals("introSequence")){
            System.out.println("OPTIONS:\n + Look \n + Move \n + Examine");
        } else if (place.equals("midgameSequence")){
            System.out.println("OPTIONS: \n + Go\n + Land\n + Status");
        }
    }
}