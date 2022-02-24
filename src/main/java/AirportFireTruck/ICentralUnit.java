package AirportFireTruck;

import Cabin.Display;
import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;

public interface ICentralUnit {
    public void changeVehicleDirection(int change);

    public void increaseSpeed();

    public void decreaseSpeed();
    public void iterate();
    public GasPedal getGasPedal();
    public BrakePedal getBrakePedal();
    public SteeringWheel getSteeringWheel();
    public Display getDisplay();
}
