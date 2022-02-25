package Lights;

import Enums.*;

public abstract class Light {
    LightColour colour;
    LateralPosition postion;
    FrontRearSide frontRearSide;
    LeftRightSide leftRightSide;
    public boolean isOn;

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
}
