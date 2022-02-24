package AirportFireTruck;

import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;

public interface ICentralUnit {
    public void changeVehicleDirection(int change);

    public void increaseSpeed();

    public void decreaseSpeed();

    public GasPedal getGasPedal();
    public BrakePedal getBrakePedal();
    public SteeringWheel getSteeringWheel();
}
