package Driving;

public class ElectricEngine {
    int speed;

    int increase(){
        return speed = speed + 4;
    }
    int decrease(){
        if (speed > 0) {
            return speed = speed - 4;
        }
        return speed;
    }

    public int getSpeed() {
        return speed;
    }

    void iterate(){
        BatteryManagement.INSTANCE.takeOutEnergy((int) (speed*12.5));
    }
}
