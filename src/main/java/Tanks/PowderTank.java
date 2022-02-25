package Tanks;

import java.util.Arrays;

public class PowderTank extends Tank {
    private int[][][] capacity;

    public PowderTank() {
        pointer = (75*45*10);
        capacity = new int[75][45][10];
        Arrays.fill(capacity[0][0],1);
        Arrays.fill(capacity[0],capacity[0][0]);
        Arrays.fill(capacity,capacity[0]);
    }

    public int getMaxAmount() {
        return 33750;
    }

    @Override
    public void fillIn(int amount) {
        while (amount > 0 && pointer < (75*45*10)) {
            capacity[74 - ((pointer / 10) % 75)][pointer / 750][pointer % 10] = 1;
            pointer++;
            amount--;
        }
    }

    @Override
    public int takeOut(int amount) {
        int result = 0;
        while (amount > 0 && pointer > 0) {
            pointer--;
            capacity[74 - ((pointer / 10) % 75)][pointer / 750][pointer % 10] = 0;
            amount--;
            result++;
        }
        return result;
    }
    public int getFill() {
        return pointer;
    }
}
