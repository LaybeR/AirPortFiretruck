package Controller;

import AirportFireTruck.ICentralUnit;

public class SteeringWheel {
    private int position;
    private final ICentralUnit centralUnit;

    public SteeringWheel(ICentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void turnLeft() {
        position = -5;
        sendUpdate();
    }

    public void turnRight() {
        position = 5;
        sendUpdate();
    }

    public void returnToCenter() {
        position = 0;
        sendUpdate();
    }

    private void sendUpdate() {
        centralUnit.changeVehicleDirection(position);
    }
}
