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
    void takeOut(int amount){
        int left = batteryBox[0][0].takeOut(amount);
        if (left > 0){
            left = batteryBox[1][0].takeOut(amount);
        }
        if (left > 0){
            left = batteryBox[0][1].takeOut(amount);
        }
        if (left > 0){
            left = batteryBox[1][1].takeOut(amount);
        }
    }
    int getCurrentCharge(){
        if (batteryBox[0][0].pointer < 100000) return batteryBox[0][0].pointer;
        if (batteryBox[1][0].pointer < 100000) return batteryBox[1][0].pointer;
        if (batteryBox[0][1].pointer < 100000) return batteryBox[0][1].pointer;
        else return batteryBox[1][1].pointer;

    }
}
