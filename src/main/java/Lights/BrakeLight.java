package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.Postion;

public class BrakeLight  extends Light {

    public BrakeLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.RED;
        postion = Postion.BOTTOM;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}