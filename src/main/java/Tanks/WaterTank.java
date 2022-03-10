package Tanks;

import java.util.ArrayList;
import java.util.Arrays;

public class WaterTank extends Tank {
    private int[][][] capacity;
    private final ArrayList<ITankListener> listenerList;

    public WaterTank() {
        listenerList = new ArrayList<>();
        pointer = (75*45*30);
        capacity = new int[75][45][30];
        Arrays.fill(capacity[0][0],1);
        Arrays.fill(capacity[0],capacity[0][0]);
        Arrays.fill(capacity,capacity[0]);
    }

    public void addListener(ITankListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ITankListener listener) {
        listenerList.remove(listener);
    }

    public int getMaxAmount() {
        return 101250;
    }

    @Override
    public void fillIn(int amount) {
        while (amount > 0 && pointer < (75*45*30)) {
            capacity[74 - ((pointer / 30) % 75)][pointer / 2250][pointer % 30] = 1;
            pointer++;
            amount--;
        }
        for (ITankListener listener : listenerList) {
            listener.update(pointer / (75.f*45*30));
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
        for (ITankListener listener : listenerList) {
            listener.update(pointer / (75.f*45*30));
        }
        return result;
    }

    public int getFill() {
        return pointer;
    }
}
