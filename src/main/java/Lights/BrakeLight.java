package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;

public class BrakeLight  extends Light {

    public BrakeLight(LeftRightSide leftRightSide) {
        colour = LightColour.RED;
        postion = LateralPosition.BOTTOM;
        frontRearSide = FrontRearSide.REAR;
        this.leftRightSide = leftRightSide;
    }
}