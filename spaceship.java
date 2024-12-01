class spaceShip{
    
    static int rations;
    int fuel;
    int orbitalDistance;

    public spaceShip(int rations, int fuel){
        this.rations = rations;
        this.fuel = fuel;
        this.orbitalDistance = 1;
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
        int distance = Math.abs(bodyName.orbitalRadius - this.orbitalDistance);
        if (fuel < distance){
            System.out.println("You don't have enough fuel to go here!");
        } else{
            if(distance == 0){
                System.out.println("You are already here!");
            } else{
                fuel -= distance;
                this.orbitalDistance = bodyName.orbitalRadius;
                System.out.println("You are now in " + bodyName.name + "'s orbit!");
                System.out.println(bodyName.description);
            }
        }
        
    }

    public void land(celestialBody bodyName){
        if (this.orbitalDistance == bodyName.orbitalRadius){
            System.out.println("Landing on " + bodyName.name + "..."); //bodyname doesn't work?
            System.out.println("Welcome to " + bodyName.name + "!");
            this.fuel -= 1;
        } else{
            System.out.println("You cannot land on a body you are not near! Go to this body before you land.");
        }
    }

    public void takeOff(celestialBody bodyName){
        if (this.orbitalDistance == bodyName.orbitalRadius){
            System.out.println("Leaving " + bodyName + "..."); //bodyname doens't work?
            System.out.println("Welcome to space!");
            this.fuel -= 1;
        } else{
            System.out.println("You are not on this body and cannot take off from it.");
        }
    }

    public void getStatus(){
        System.out.println("CURRENT STATUS: \n + Fuel = " + this.fuel + "\n + Rations = " + this.rations); 
    }
}