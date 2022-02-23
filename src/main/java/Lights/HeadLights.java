package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.Postion;

public class HeadLights extends Light {

    public HeadLights(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = Postion.BOTTOM;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}
