package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.Postion;

public class RoofLight  extends Light {

    public RoofLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = Postion.TOP;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}