package Cannon;

public class FloorCannon {
    Boolean activated;

    public void activate(){
        activated = true;
    }
    public void deactivate(){
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
