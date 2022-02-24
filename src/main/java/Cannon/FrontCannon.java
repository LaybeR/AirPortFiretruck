package Cannon;

public class FrontCannon extends Cannon {

    @Override
    public void activate() {
        super.activate();
        rotationInDeg = 90;
    }

    @Override
    public void deactivate() {
        super.activate();
        rotationInDeg = 0;
    }

}
