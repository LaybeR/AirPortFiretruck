package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;

public class HeadLights extends Light {

    public HeadLights(LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.BOTTOM;
        frontRearSide = FrontRearSide.FRONT;
        this.leftRightSide = leftRightSide;
    }
}
