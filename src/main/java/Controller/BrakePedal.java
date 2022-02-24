package Controller;

import AirportFireTruck.ICentralUnit;

public class BrakePedal {
    private final ICentralUnit centralUnit;

    public BrakePedal(ICentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void press() {
        centralUnit.decreaseSpeed();
    }
}
