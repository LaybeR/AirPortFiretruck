package Cannon;

public class CannonVisitor implements ICannonVisitor {

    @Override
    public boolean visit(FrontCannon cannon) {
        return false;
    }

    @Override
    public boolean visit(RoofCannon cannon) {
        return false;
    }

    @Override
    public boolean visit(FloorCannon cannon) {
        return false;
    }
}
