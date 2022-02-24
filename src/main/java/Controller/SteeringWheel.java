package Controller;

import AirportFireTruck.ICentralUnit;
import Enums.SteeringDirection;

public class SteeringWheel {
    private int position;
    private final ICentralUnit centralUnit;

    public SteeringWheel(ICentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void turnLeft() {
        position = -5;
        centralUnit.changeVehicleDirection(position, SteeringDirection.LEFT);
    }

    public void turnRight() {
        position = 5;
        centralUnit.changeVehicleDirection(position, SteeringDirection.RIGHT);
    }

    public void returnToCenter() {
        position = 0;
        centralUnit.changeVehicleDirection(position, SteeringDirection.CENTER);
    }
}
