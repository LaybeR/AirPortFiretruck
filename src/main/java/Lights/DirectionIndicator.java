package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.Postion;

public class DirectionIndicator  extends Light {

    public DirectionIndicator(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.ORANGE;
        postion = Postion.BOTTOM;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}
