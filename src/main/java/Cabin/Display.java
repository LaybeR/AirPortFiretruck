package Cabin;

import AirportFireTruck.ICentralUnit;

public class Display {
    double remainingEnergy;
    int speed;
    ICentralUnit CU;
    double getRemainingEnergy(){
        System.out.println("Energy remaining: " + remainingEnergy);
        return remainingEnergy;
    }
    public int getSpeed(){
        return speed;
    }
    public Display(ICentralUnit Cu){
    this.CU = Cu;
    }
    public void setSpeed(int n){
        speed = n;
    }

}
