package Driving;

public class ElectricEngine {
    int speed;
    boolean on;

    public ElectricEngine() {
        speed = 0;
        on = false;
    }

    int increase(){
        if (!on) return speed;
        return speed = speed + 4;
    }
    int decrease(){
        if (!on) return speed;
        if (speed > 0) {
            return speed = speed - 4;
        }
        return speed;
    }

    void changeStatus(boolean on) {
        this.on = on;
    }

    public int getSpeed() {
        return speed;
    }

    void iterate(){
        BatteryManagement.INSTANCE.takeOutEnergy((int) (speed*12.5));
    }
}
