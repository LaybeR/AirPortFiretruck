package Driving;

import java.util.Arrays;

public class BatteryBox {
    Battery[][] batteryBox = new Battery[2][2];
    BatteryBox() {
        create();
    }
    void create(){
       Arrays.fill(batteryBox[0], new Battery());
       Arrays.fill(batteryBox, batteryBox[0]);

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
            left = batteryBox[1][1].charge(amount);
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
        return batteryBox[0][0].pointer + batteryBox[1][0].pointer + batteryBox[0][1].pointer + batteryBox[1][1].pointer;
    }

    int getMaxCharge() {
        return batteryBox[0][0].getMaxCharge() * 4;
    }

    public Battery[][] getBatteryBox() {
        return batteryBox;
    }
}
