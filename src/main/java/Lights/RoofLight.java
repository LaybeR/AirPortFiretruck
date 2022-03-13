package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.RoofLightEventOff;
import Events.RoofLightEventOn;
import Events.WarningLightEventOff;
import Events.WarningLightEventOn;
import org.greenrobot.eventbus.Subscribe;

public class RoofLight  extends Light {

    public RoofLight(LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.TOP;
        frontRearSide = FrontRearSide.FRONT;
        this.leftRightSide = leftRightSide;
    }

    @Subscribe
    public void turnOn(RoofLightEventOn roofLightEventOn){
        isOn = true;
    }
    @Subscribe
    public void turnOff(RoofLightEventOff roofLightEventOff){
        isOn = false;
    }
}