package Tanks;

import java.util.Arrays;

public class WaterTank extends Tank {
    private int[][][] capacity;

    public WaterTank() {
        pointer = (75*45*10)-1;
        capacity = new int[75][45][30];
        Arrays.fill(capacity[0][0],1);
        Arrays.fill(capacity[0],capacity[0][0]);
        Arrays.fill(capacity,capacity[0]);
    }

    @Override
    public void fillIn(int amount) {
        while (amount > 0 && pointer < (75*45*10)) {
            capacity[74 - ((pointer / 30) % 75)][pointer / 2250][pointer % 30] = 1;
            pointer++;
            amount--;
        }
    }

    @Override
    public int takeOut(int amount) {
        int result = 0;
        while (amount > 0 && pointer > 0) {
            pointer--;
            capacity[74 - ((pointer / 30) % 75)][pointer / 2250][pointer % 30] = 0;
            amount--;
            result++;
        }
        return result;
    }
}
