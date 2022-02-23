package Driving;

import static Enums.LeftRightPosition.LEFT;
import static Enums.LeftRightPosition.RIGHT;

public abstract class Pivot {
    Pivot (){
        BrakeDisc BD0 = new BrakeDisc(LEFT);
        BrakeDisc BD1 = new BrakeDisc(RIGHT);
        BrakeDisc BD2 = new BrakeDisc(LEFT);
        BrakeDisc BD3 = new BrakeDisc(RIGHT);
        BrakeDisc BD4 = new BrakeDisc(LEFT);
        BrakeDisc BD5 = new BrakeDisc(RIGHT);

        Tire T1 = new Tire();
        Tire T2 = new Tire();
    }
}
