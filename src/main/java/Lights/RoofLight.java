package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;

public class RoofLight  extends Light {

    public RoofLight(LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.TOP;
        frontRearSide = FrontRearSide.FRONT;
        this.leftRightSide = leftRightSide;
    }
}