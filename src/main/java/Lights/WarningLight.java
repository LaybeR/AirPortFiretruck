package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.Postion;

public class WarningLight extends FlashingLight {

    public WarningLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.ORANGE;
        postion = Postion.TOP;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}
