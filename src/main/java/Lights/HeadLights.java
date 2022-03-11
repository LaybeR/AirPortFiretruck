package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.HeadLightEvent;
import org.greenrobot.eventbus.Subscribe;

public class HeadLights extends Light {

    public HeadLights(LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.BOTTOM;
        frontRearSide = FrontRearSide.FRONT;
        this.leftRightSide = leftRightSide;
    }

    @Subscribe
    public void changeState(HeadLightEvent headLightEvent){
        isOn = !isOn;
    }
}
