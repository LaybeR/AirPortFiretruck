package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;

public class DirectionIndicator  extends Light {

    public DirectionIndicator(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.ORANGE;
        postion = LateralPosition.BOTTOM;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}
