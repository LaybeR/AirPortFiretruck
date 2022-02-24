package Cabin;

import Enums.LeftRightPosition;

public class JoystickButton {
    private final LeftRightPosition side;
    private final Joystick stick;
    public void press(){
        stick.pressJoystickButton(side);
    }

    JoystickButton(LeftRightPosition sde, Joystick stick){
        this.side = sde;
        this.stick = stick;
    }

}
