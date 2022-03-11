package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.HeadLightEvent;
import Events.SideLightEvent;
import org.greenrobot.eventbus.Subscribe;

public class SideLight  extends Light {

    public SideLight(FrontRearSide frontRearSide, LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.BOTTOM;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
    }

    @Subscribe
    public void changeState(SideLightEvent sideLightEvent){
        isOn = !isOn;
    }
}