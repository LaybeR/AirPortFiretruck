package Driving;

import AirportFireTruck.ICentralUnit;

public enum BatteryManagement {
    INSTANCE;
    private final ICentralUnit CU;

    BatteryBox batteryBox;

    BatteryManagement(ICentralUnit Cu){
        this.CU = Cu;
        create();
    }

    void create(){
    batteryBox = new BatteryBox();
    }

    public int getCurrentCharge(){
    return batteryBox.getCurrentCharge();
    }
}
