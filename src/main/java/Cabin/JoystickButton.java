package Cabin;

import Enums.LeftRightPosition;
import User.Driver;
import User.IUser;
import User.Operator;

public class JoystickButton {
    private final LeftRightPosition side;
    private final Joystick stick;
    public void press(IUser user){
        if ((stick.side == LeftRightPosition.LEFT && user instanceof Driver) || (stick.side == LeftRightPosition.RIGHT && user instanceof Operator)) {
            stick.pressJoystickButton(side);
        }
    }

    JoystickButton(LeftRightPosition sde, Joystick stick){
        this.side = sde;
        this.stick = stick;
    }

}
