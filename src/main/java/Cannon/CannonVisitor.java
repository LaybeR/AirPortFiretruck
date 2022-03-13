package Cannon;

import Events.SelfProtectionEventOff;
import Events.SelfProtectionEventOn;
import org.greenrobot.eventbus.EventBus;

public class CannonVisitor implements ICannonVisitor {

    @Override
    public boolean visit(FrontCannon cannon) {
        cannon.activate();
        if (cannon.activated != cannon.isActivated() || !cannon.activated || cannon.rotationInDeg != 90) {
            return false;
        }
        cannon.deactivate();
        if (cannon.activated != cannon.isActivated() || cannon.activated || cannon.rotationInDeg != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean visit(RoofCannon cannon) {
        cannon.activate();
        if (cannon.activated != cannon.isActivated() || !cannon.activated || cannon.rotationInDeg != 90 || cannon.stDeg != 90) {
            return false;
        }
        cannon.deactivate();
        if (cannon.activated != cannon.isActivated() || cannon.activated || cannon.rotationInDeg != 0 || cannon.stDeg != 0) {
            return false;
        }
        cannon.extendArm();
        if (cannon.length != 17) return false;
        cannon.contractArm();
        if (cannon.length != 6) return false;
        return true;
    }

    @Override
    public boolean visit(FloorCannon cannon) {
        EventBus.getDefault().post(new SelfProtectionEventOn());
        if (cannon.activated != cannon.isActivated() || !cannon.activated) {
            return false;
        }
        EventBus.getDefault().post(new SelfProtectionEventOff());
        if (cannon.activated != cannon.isActivated() || cannon.activated) {
            return false;
        }
        return true;
    }
}
