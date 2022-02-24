package AirportFireTruck;

import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;

public class CentralUnit implements ICentralUnit {
    private final GasPedal gasPedal;
    private final BrakePedal brakePedal;
    private final SteeringWheel steeringWheel;

    public CentralUnit() {
        this.gasPedal = new GasPedal(this);
        this.brakePedal = new BrakePedal(this);
        this.steeringWheel = new SteeringWheel(this);
    }

    public void changeVehicleDirection(int change) {

    }

    @Override
    public void increaseSpeed() {

    }

    @Override
    public void decreaseSpeed() {

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
