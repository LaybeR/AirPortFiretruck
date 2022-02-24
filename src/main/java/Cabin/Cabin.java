package Cabin;

import AirportFireTruck.ICentralUnit;
import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import Enums.LeftRightSide;
import User.User;

public class Cabin {
    Seat[][] seats = new Seat[2][2];
    public final Joystick LJ;
    public final Joystick RJ;
    public final Door LD;
    public final Door RD;
    private final ICentralUnit centralUnit;

    void sitIn(User user, LeftRightSide side){

    }

    public Cabin(ICentralUnit centralUnit){
        this.centralUnit = centralUnit;
        seats[0][0] = new Seat(LeftRightPosition.LEFT, FrontBackPosition.FRONT);
        seats[0][1] = new Seat(LeftRightPosition.RIGHT, FrontBackPosition.FRONT);
        seats[1][0] = new Seat(LeftRightPosition.LEFT, FrontBackPosition.BACK);
        seats[1][1] = new Seat(LeftRightPosition.RIGHT, FrontBackPosition.BACK);
        LJ = new Joystick(LeftRightPosition.LEFT, this);
        RJ = new Joystick(LeftRightPosition.RIGHT, this);
        LD = new Door(LeftRightPosition.LEFT);
        RD = new Door(LeftRightPosition.RIGHT);
    }

    public void holdFeeler(LeftRightPosition side){

    }

    public void releaseFeeler(LeftRightPosition side) {

    }

    public void pressJoystickButton(LeftRightPosition joystickSide, LeftRightPosition buttonSide) {

    }
}
