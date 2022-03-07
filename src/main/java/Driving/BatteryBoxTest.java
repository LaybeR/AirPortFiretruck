package Driving;

public class BatteryBoxTest {
    public static void main(String[] args) {
        BatteryBox batteryBox = new BatteryBox();
        System.out.println(batteryBox.getCurrentCharge());
        batteryBox.charge(1000);
        System.out.println(batteryBox.getCurrentCharge());
        batteryBox.charge(1000);
        System.out.println(batteryBox.getCurrentCharge());
        batteryBox.takeOut(500);
        System.out.println(batteryBox.getCurrentCharge());

    }
}
