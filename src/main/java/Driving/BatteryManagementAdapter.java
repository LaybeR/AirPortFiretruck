package Driving;


public class BatteryManagementAdapter implements  Charger{
    BatteryManagement batteryManagement;
    Pole[] poles = new Pole[3];
    public BatteryManagementAdapter(BatteryManagement batteryManagement){
        this.batteryManagement = batteryManagement;
    }
    public void charge(){

        poles[0].charge(batteryManagement,400);
        poles[1].charge(batteryManagement,300);
        poles[2].charge(batteryManagement,300);
    }

}
