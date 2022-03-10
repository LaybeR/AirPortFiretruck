package Cannon;

public class RoofCannon extends Cannon {
    private int length;
    int stDeg;
    public void extendArm() {
        length = 17;
    }

    public void contractArm() {
    length = 6;
    }

    @Override
    public void activate() {
        super.activate();
        rotationInDeg = 90;
        stDeg = 90;
    }

    @Override
    public void deactivate() {
        super.deactivate();
        rotationInDeg = 0;
        stDeg = 0;
    }

    public boolean accept(ICannonVisitor visitor) {
        return visitor.visit(this);
    }
}
