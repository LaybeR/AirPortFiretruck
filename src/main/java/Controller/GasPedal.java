package Controller;

import AirportFireTruck.ICentralUnit;

public class GasPedal {
    private final ICentralUnit centralUnit;

    public GasPedal(ICentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void press() {
        centralUnit.increaseSpeed();
    }
}
