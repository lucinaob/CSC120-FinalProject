class spaceship{
    
    Number rations;
    Number fuel;
    Number orbitalDistance;

    public spaceship(Number rations, Number fuel){
        this.rations = rations;
        this.fuel = fuel;
        this.orbitalDistance = 1;
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

    public land(celestialBody bodyName){
        //If this.orbitalDistance == celestialBody.orbitalDistance
            //Land on body
            //Decrease fuel by 1?
            //Print that you are now on (bodyName)
        //Else
        
    }
}