package Driving;

import AirportFireTruck.ICentralUnit;

public enum BatteryManagement {
    INSTANCE;
    private ICentralUnit CU;

    BatteryBox batteryBox;

    public void setCU(ICentralUnit Cu){
        this.CU = Cu;
        create();
    }

    void create(){
        batteryBox = new BatteryBox();
    }
    public void charge(int amount) {batteryBox.charge(amount);}

    public int takeOutEnergy(int amount) {
        return batteryBox.takeOut(amount);
    }

    public int getMaxCharge() {return batteryBox.getMaxCharge();}

    public int getCurrentCharge(){
    return batteryBox.getCurrentCharge();
    }
}
