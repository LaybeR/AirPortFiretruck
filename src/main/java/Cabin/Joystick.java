package Cabin;

import Enums.LeftRightPosition;

public class Joystick {
    LeftRightPosition side;
    public final JoystickButton LB;
    public final JoystickButton RB;
    public final Feeler feeler;
    private final Cabin cabin;

    public Joystick(LeftRightPosition sde, Cabin cabin) {
        this.side = sde;
        this.cabin =cabin;
        LB = new JoystickButton(LeftRightPosition.LEFT, this);
        RB = new JoystickButton(LeftRightPosition.RIGHT, this);
        feeler = new Feeler(this);
    }

    void holdFeeler() {
        cabin.holdFeeler(side);
    }

    void releaseFeeler() {
        cabin.releaseFeeler(side);
    }

    void pressJoystickButton(LeftRightPosition position) {
        cabin.pressJoystickButton(side,position);
    }

    public LeftRightPosition getLeftRightPosition() {
        return side;
    }
}

