package Cannon;

public class CannonVisitor implements ICannonVisitor {

    @Override
    public boolean visit(FrontCannon cannon) {
        cannon.activate();
        if (cannon.activated != cannon.isActivated() || !cannon.activated) {
            return false;
        }
        cannon.deactivate();
        if (cannon.activated != cannon.isActivated() || cannon.activated) {
            return false;
        }
        return true;
    }

    @Override
    public boolean visit(RoofCannon cannon) {
        cannon.activate();
        if (cannon.activated != cannon.isActivated() || !cannon.activated) {
            return false;
        }
        cannon.deactivate();
        if (cannon.activated != cannon.isActivated() || cannon.activated) {
            return false;
        }
        return true;
    }

    @Override
    public boolean visit(FloorCannon cannon) {
        cannon.activate();
        if (cannon.activated != cannon.isActivated() || !cannon.activated) {
            return false;
        }
        cannon.deactivate();
        if (cannon.activated != cannon.isActivated() || cannon.activated) {
            return false;
        }
        return true;
    }
}
