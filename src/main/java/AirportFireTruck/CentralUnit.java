package AirportFireTruck;

import Cabin.Display;
import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;
import Driving.BatteryManagement;

public class CentralUnit implements ICentralUnit {
    private final GasPedal gasPedal;
    private final BrakePedal brakePedal;
    private final SteeringWheel steeringWheel;
    private final Display display;
    private final BatteryManagement batteryManagement;

    public CentralUnit() {
        this.gasPedal = new GasPedal(this);
        this.brakePedal = new BrakePedal(this);
        this.steeringWheel = new SteeringWheel(this);
        this.display = new Display(this);
        this.batteryManagement = new BatteryManagement(this);
    }

    public void changeVehicleDirection(int change) {

    }

    @Override
    public void increaseSpeed() {
    display.setSpeed(display.getSpeed() + 5);
    }

    @Override
    public void decreaseSpeed() {
        display.setSpeed(display.getSpeed() - 5);
    }

    public Display getDisplay(){
        return display;
    }

    public GasPedal getGasPedal() {
        return gasPedal;
    }

    public BrakePedal getBrakePedal() {
        return brakePedal;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }
}
