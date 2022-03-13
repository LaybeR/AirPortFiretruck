package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.SideLightEventOff;
import Events.SideLightEventOn;
import Events.WarningLightEventOff;
import Events.WarningLightEventOn;
import org.greenrobot.eventbus.Subscribe;

public class SideLight  extends Light {

    public SideLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.BOTTOM;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }

    @Subscribe
    public void turnOn(SideLightEventOn sideLightEventOn){
        isOn = true;
    }
    @Subscribe
    public void turnOff(SideLightEventOff sideLightEventOff){
        isOn = false;
    }
}