import java.util.ArrayList;

class spaceship{
    
    Number rations;
    Number fuel;
    Number orbitalDistance;
    private ArrayList<Being> onboard; // what rover currenty contains 

    public spaceship(Number rations, Number fuel){
        this.rations = rations;
        this.fuel = fuel;
        this.onboard = new ArrayList<>(); 
        this.orbitalDistance = 1;
    }

    private void board(Being being){
        // function for a being to board spaceship
        this.onboard.add(being); 
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
        //If this.orbitalDistance == celestialBody.orbitalDistance
            //Land on body
            //Decrease fuel by 1?
            //Print that you are now on (bodyName)
        //Else
        System.out.println("You cannot land on a body you are not near! Go to this body before you land.");
    }

    public void takeOff(celestialBody bodyName){
        //If this.orbitalDistance == celestialBody.orbitalDistance
            //Take off
            //Fuel - 1?
            //Print that you are now in space
        //Else,
        System.out.println("You are not on this body and cannot take off from it.");
    }

    }

