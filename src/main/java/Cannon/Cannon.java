package Cannon;

public abstract class Cannon {
    private boolean activated;
    private int rotationInDeg;
    private double neededRatio;

    public void rotateLeft() {}

    public void rotateRight() {}

    public void activate() {
        activated = true;
    }

    public void deactivate() {
        activated = false;
    }

    public void changeRatio(int position) {}
}
