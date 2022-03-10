package AirportFireTruck;

import Cabin.Display;
import Cannon.FloorCannon;
import Cannon.FrontCannon;
import Cannon.IMixer;
import Cannon.RoofCannon;
import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.SteeringWheel;
import Driving.BatteryManagement;
import Driving.Chassis;
import Enums.SteeringDirection;
import Enums.SwitchType;
import Lights.*;
import Tanks.PowderTank;
import Tanks.WaterTank;
import User.IUser;

public interface ICentralUnit {
    void changeVehicleDirection(int change, SteeringDirection direction);

    void increaseSpeed();

    void decreaseSpeed();
     void iterate();
     GasPedal getGasPedal();
     BrakePedal getBrakePedal();
     SteeringWheel getSteeringWheel();
     Display getDisplay();
     RoofCannon getRoofCannon();
     FloorCannon[] getFloorCannons();
     FrontCannon getFrontCannon();
     PowderTank getPowderTank();
     WaterTank getWaterTank();
     IMixer getMixer();
     BatteryManagement getBatteryManagement();
     void postDisplay();
     void turnSwitchOn(SwitchType s, IUser user);
     void turnSwitchOff(SwitchType s, IUser user);
     BrakeLight[] getBrakeLights();
     EmergencyLight[] getEmergencyLights();
     DirectionIndicator[] getTurnRight();
     HeadLights[] getHeadLights();
     RoofLight[] getRoofLights();
     WarningLight[] getWarningLights();
     DirectionIndicator[] getTurnLeft();
     Chassis getChassis();
    void setListener(FillGaugeLED waterTankL, FillGaugeLED powderTankL);
}
