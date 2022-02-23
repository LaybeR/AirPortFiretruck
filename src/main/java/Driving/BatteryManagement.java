package Driving;

public enum BatteryManagement {
    INSTANCE;

    BatteryBox batteryBox;

    BatteryManagement(){
        create();
    }

    void create(){
    batteryBox = new BatteryBox();
    }

    int getCurrentCharge(){
    return batteryBox.getCurrentCharge();
    }
}
