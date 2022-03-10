package Cabin;

import Enums.LeftRightPosition;
import User.Driver;
import User.IUser;
import User.Operator;

public class Feeler {
    private final Joystick stick;


    public Feeler(Joystick stick) {
        this.stick = stick;
    }

    public void hold(IUser user) {
        if ((stick.side == LeftRightPosition.LEFT && user instanceof Driver) || (stick.side == LeftRightPosition.RIGHT && user instanceof Operator)) {
            stick.holdFeeler();
        }
    }

    public void release(IUser user) {
        if ((stick.side == LeftRightPosition.LEFT && user instanceof Driver) || (stick.side == LeftRightPosition.RIGHT && user instanceof Operator)) {
            stick.releaseFeeler();
        }
    }
}
