package Lights;

import Enums.*;
import org.greenrobot.eventbus.Subscribe;

public abstract class Light {
    LightColour colour;
    LateralPosition postion;
    FrontRearSide frontRearSide;
    LeftRightSide leftRightSide;
    public boolean isOn;


    @Subscribe
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
}
