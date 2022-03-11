package Lights;

import Enums.FrontRearSide;
import Enums.LeftRightSide;
import Enums.LightColour;
import Enums.LateralPosition;
import Events.HeadLightEvent;
import Events.RoofLightEvent;
import org.greenrobot.eventbus.Subscribe;

public class RoofLight  extends Light {

    public RoofLight(LeftRightSide leftRightSide) {
        colour = LightColour.WHITE;
        postion = LateralPosition.TOP;
        frontRearSide = FrontRearSide.FRONT;
        this.leftRightSide = leftRightSide;
    }

    @Subscribe
    public void changeState(RoofLightEvent roofLightEvent){
        isOn = !isOn;
    }
}