package Cannon;

import org.greenrobot.eventbus.Subscribe;

public class FloorCannon {
    Boolean activated;


    @Subscribe
    public void activate(){
        activated = true;
    }
    public void deactivate(){
        activated = false;
    }
    @Subscribe
    public void changeStatus(){
        activated = !activated;
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
