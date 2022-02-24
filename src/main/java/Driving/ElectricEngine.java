package Driving;

public class ElectricEngine {
    int speed;

    int increase(){
        return speed = speed + 5;
    }
    int decrease(){
        return speed = speed - 5;
    }

    public int getSpeed() {
        return speed;
    }

    void iterate(){

    }
}
