package Tanks;

public class PowderTank extends Tank {
    private int[][][] capacity;

    public PowderTank() {
        capacity = new int[75][45][10];
    }

    @Override
    public void fillIn(int amount) {

    }

    @Override
    public int takeOut(int amount) {
        return 0;
    }
}
