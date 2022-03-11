package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.HeadLightEvent;
import Events.WarningLightEvent;
import org.greenrobot.eventbus.Subscribe;

public class WarningLight extends FlashingLight {

    public WarningLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.ORANGE;
        postion = LateralPosition.TOP;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }

    @Subscribe
    public void changeState(WarningLightEvent warningLightEvent){
        isOn = !isOn;
    }
}
