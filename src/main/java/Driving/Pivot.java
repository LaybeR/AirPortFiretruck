package Driving;

import static Enums.LeftRightPosition.LEFT;
import static Enums.LeftRightPosition.RIGHT;

public abstract class Pivot {
    private final BrakeDisc[] brakeDiscs;
    private final Tire leftTire;
    private final Tire rightTire;
    Pivot (){
        brakeDiscs = new BrakeDisc[6];
        brakeDiscs[0] = new BrakeDisc(LEFT);
        brakeDiscs[1] = new BrakeDisc(RIGHT);
        brakeDiscs[2] = new BrakeDisc(LEFT);
        brakeDiscs[3] = new BrakeDisc(RIGHT);
        brakeDiscs[4] = new BrakeDisc(LEFT);
        brakeDiscs[5] = new BrakeDisc(RIGHT);
        leftTire = new Tire(LEFT);
        rightTire = new Tire(RIGHT);
    }

}
