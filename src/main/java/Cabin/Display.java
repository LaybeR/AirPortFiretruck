package Cabin;

import AirportFireTruck.ICentralUnit;

public class Display {
    double remainingEnergy;
    int speed;
    ICentralUnit CU;

    public void setRemainingEnergy(double remainingEnergy) {
        this.remainingEnergy = remainingEnergy;
    }

    public double getRemainingEnergy(){
        System.out.println("Energy remaining: " + remainingEnergy);
        return remainingEnergy;
    }
    public int getSpeed(){
        System.out.println("Speed:" + speed);
        return speed;
    }

    public Display(ICentralUnit Cu){
        this.CU = Cu;
        remainingEnergy = 1;
        speed = 0;
    }

    public void setSpeed(int n){
        speed = n;
    }

}
