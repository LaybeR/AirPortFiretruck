package Driving;

public class ChargingStation implements Charger{
    BatteryManagementAdapter batteryManagementAdapter = null;

    public void charge(){
        if(batteryManagementAdapter != null){
        batteryManagementAdapter.charge();
        }

    }

    public void plugIn(BatteryManagementAdapter batteryManagementAdapter){
        this.batteryManagementAdapter = batteryManagementAdapter;
    }

    public void plugOut(){
        this.batteryManagementAdapter = null;
    }
}
