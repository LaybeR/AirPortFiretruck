package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.HeadLightEventOff;
import Events.HeadLightEventOn;
import Events.WarningLightEventOff;
import Events.WarningLightEventOn;
import org.greenrobot.eventbus.Subscribe;

public class HeadLights extends Light {

    public HeadLights(LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.BOTTOM;
        frontRearSide = FrontRearSide.FRONT;
        this.leftRightSide = leftRightSide;
    }

    @Subscribe
    public void turnOn(HeadLightEventOn headLightEventOn){
        isOn = true;
    }
    @Subscribe
    public void turnOff(HeadLightEventOff headLightEventOff){
        isOn = false;
    }
}
