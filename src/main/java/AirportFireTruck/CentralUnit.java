package AirportFireTruck;

import Cabin.Display;
import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;
import Driving.BatteryManagement;
import Driving.Chassis;

public class CentralUnit implements ICentralUnit {
    private final GasPedal gasPedal;
    private final BrakePedal brakePedal;
    private final SteeringWheel steeringWheel;
    private final Display display;
    private final BatteryManagement batteryManagement;
    private final Chassis chassis;

    public CentralUnit() {
        this.gasPedal = new GasPedal(this);
        this.brakePedal = new BrakePedal(this);
        this.steeringWheel = new SteeringWheel(this);
        this.display = new Display(this);
        this.batteryManagement = BatteryManagement.INSTANCE;
        batteryManagement.setCU(this);
        this.chassis = new Chassis();
    }

    public void changeVehicleDirection(int change) {

    }

    public void iterate() {
        chassis.iterate();
    }

    @Override
    public void increaseSpeed() {
        chassis.increaseSpeed();
        display.setSpeed(chassis.getSpeed());
    }

    @Override
    public void decreaseSpeed() {
        chassis.decreaseSpeed();
        display.setSpeed(chassis.getSpeed());
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
