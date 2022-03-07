package Driving;

import java.util.Arrays;

public class BatteryBox {
    private final Battery[][] batteryBox;
    BatteryBox() {
        batteryBox = new Battery[2][2];
        batteryBox[0][0] = new Battery();
        batteryBox[1][0] = new Battery();
        batteryBox[0][1] = new Battery();
        batteryBox[1][1] = new Battery();
    }

    public void charge(int amount){
        int left = batteryBox[0][0].charge(amount);
        if (left > 0){
            left = batteryBox[1][0].charge(amount);
        }
        if (left > 0){
            left = batteryBox[0][1].charge(amount);
        }
        if (left > 0){
            batteryBox[1][1].charge(amount);
        }
    }
    public int takeOut(int amount){
        int result = batteryBox[0][0].takeOut(amount);
        if (result < amount){
            result += batteryBox[1][0].takeOut(amount-result);
        }
        if (result < amount){
            result += batteryBox[1][0].takeOut(amount-result);
        }
        if (result < amount){
            result += batteryBox[1][0].takeOut(amount-result);
        }
        return result;
    }

    int getCurrentCharge(){
        return batteryBox[0][0].getCharge() + batteryBox[1][0].getCharge() + batteryBox[0][1].getCharge() + batteryBox[1][1].getCharge();
    }

    int getMaxCharge() {
        return batteryBox[0][0].getMaxCharge() * 4;
    }
}
