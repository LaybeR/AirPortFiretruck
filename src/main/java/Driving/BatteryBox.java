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

    public int getCurrentChargeFrom(int batteryNum) {
        int result = 0;
        switch (batteryNum) {
            case 1 -> result = batteryBox[0][0].pointer;
            case 2 -> result = batteryBox[1][0].pointer;
            case 3 -> result = batteryBox[0][1].pointer;
            case 4 -> result = batteryBox[1][1].pointer;
        }
        return result;
    }

    int getMaxCharge() {
        return batteryBox[0][0].getMaxCharge() * 4;
    }
}
