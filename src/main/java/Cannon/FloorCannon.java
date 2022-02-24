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
}
