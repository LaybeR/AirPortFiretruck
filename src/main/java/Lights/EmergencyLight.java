package Lights;

import Enums.*;
import Events.EmergencyLightEvent;
import Events.HeadLightEvent;
import org.greenrobot.eventbus.Subscribe;

public class EmergencyLight extends FlashingLight {
    LightSize size;
    LED[] led;

    public EmergencyLight(LateralPosition pos, FrontRearSide frontRearSide, LeftRightSide leftRightSide, LightSize size) {
        this.isOn = false;
        colour = LightColour.BLUE;
        postion = pos;
        this.leftRightSide = leftRightSide;
        this.frontRearSide = frontRearSide;
        this.size = size;
        switch (size) {
            case SMALL -> {
                led = new LED[2];
                for (int i = 0 ; i < 2; i++) {led[i] = new LED();}
            }
            case MEDIUM -> {
                led = new LED[3];
                for (int i = 0 ; i < 3; i++) {led[i] = new LED();}
            }
            case LARGE -> {
                led = new LED[4];
                for (int i = 0 ; i < 4; i++) {led[i] = new LED();}
            }
        }
    }

    @Subscribe
    public void changeState(EmergencyLightEvent emergencyLightEvent){
        isOn = !isOn;
    }

}
