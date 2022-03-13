package Driving;

public class BatteryBoxTest {
    public static void main(String[] args) {
        BatteryBox batteryBox = new BatteryBox();
        System.out.println(batteryBox.getCurrentCharge());
        batteryBox.takeOut(100000);

        System.out.println(batteryBox.getCurrentCharge());
        batteryBox.takeOut(100000);

        System.out.println(batteryBox.getCurrentCharge());
        batteryBox.charge(200000);
        System.out.println(batteryBox.getCurrentCharge());

        System.out.println(batteryBox.getCurrentCharge());
        System.out.println(batteryBox.getMaxCharge());
    }
}
