package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;

public class WarningLight extends FlashingLight {

    public WarningLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.ORANGE;
        postion = LateralPosition.TOP;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }
}
