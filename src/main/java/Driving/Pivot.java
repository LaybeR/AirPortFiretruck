package Driving;

import static Enums.LeftRightPosition.LEFT;
import static Enums.LeftRightPosition.RIGHT;

public abstract class Pivot {
    private BrakeDisc[] brakeDiscs;
    private Tire leftTire;
    private Tire rightTire;
    Pivot (){
        create();
    }

    void create() {
        brakeDiscs = new BrakeDisc[6];
        brakeDiscs[0] = new BrakeDisc(LEFT);
        brakeDiscs[1] = new BrakeDisc(RIGHT);
        brakeDiscs[2] = new BrakeDisc(LEFT);
        brakeDiscs[3] = new BrakeDisc(RIGHT);
        brakeDiscs[4] = new BrakeDisc(LEFT);
        brakeDiscs[5] = new BrakeDisc(RIGHT);
        leftTire = new Tire();
        rightTire = new Tire();
    }
}
