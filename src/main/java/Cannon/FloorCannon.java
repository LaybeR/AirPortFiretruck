package Cannon;

import Events.SelfProtectionEventOff;
import Events.SelfProtectionEventOn;
import Events.WarningLightEventOff;
import Events.WarningLightEventOn;
import org.greenrobot.eventbus.Subscribe;

public class FloorCannon {
    Boolean activated;



    @Subscribe
    public void activate(SelfProtectionEventOn selfProtectionEventOn){
        activated = true;
    }
    @Subscribe
    public void deactivate(SelfProtectionEventOff selfProtectionEventOff){
        activated = false;
    }



    public FloorCannon(){
        activated = false;
    }
     public boolean isActivated(){
        return activated;
     }

     public boolean accept(ICannonVisitor visitor) {
        return visitor.visit(this);
     }
}
