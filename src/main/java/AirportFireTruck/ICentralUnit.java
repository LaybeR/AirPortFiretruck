package AirportFireTruck;

import Cabin.Display;
import Cannon.FloorCannon;
import Cannon.FrontCannon;
import Cannon.Mixer;
import Cannon.RoofCannon;
import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;
import Driving.BatteryManagement;
import Tanks.PowderTank;
import Tanks.WaterTank;

public interface ICentralUnit {
    public void changeVehicleDirection(int change);

    public void increaseSpeed();

    public void decreaseSpeed();
    public void iterate();
    public GasPedal getGasPedal();
    public BrakePedal getBrakePedal();
    public SteeringWheel getSteeringWheel();
    public Display getDisplay();
    public RoofCannon getRoofCannon();
    public FloorCannon getFloorCannon();
    public FrontCannon getFrontCannon();
    public PowderTank getPowderTank();
    public WaterTank getWaterTank();
    public Mixer getMixer();
    public BatteryManagement getBatteryManagement();
    public void postDisplay();
}
