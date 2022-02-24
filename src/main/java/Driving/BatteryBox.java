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
    void charge(int amount){
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
    int takeOut(int amount){
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
        if (batteryBox[0][0].pointer < 100000) return batteryBox[0][0].pointer;
        if (batteryBox[1][0].pointer < 100000) return batteryBox[1][0].pointer;
        if (batteryBox[0][1].pointer < 100000) return batteryBox[0][1].pointer;
        else return batteryBox[1][1].pointer;

    }
}
