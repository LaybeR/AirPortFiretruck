package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.WarningLightEventOff;
import Events.WarningLightEventOn;
import org.greenrobot.eventbus.Subscribe;

public class WarningLight extends FlashingLight {

    public WarningLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.ORANGE;
        postion = LateralPosition.TOP;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }

    @Subscribe
    public void turnOn(WarningLightEventOn warningLightEventOn){
        isOn = true;
    }
    @Subscribe
    public void turnOff(WarningLightEventOff warningLightEventOff){
        isOn = false;
    }

}
