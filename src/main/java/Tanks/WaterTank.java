package Tanks;

public class WaterTank extends Tank {
    private int[][][] capacity;

    public WaterTank() {
        capacity = new int[75][45][30];
    }

    @Override
    public void fillIn(int amount) {

    }

    @Override
    public int takeOut(int amount) {
        return 0;
    }
}
