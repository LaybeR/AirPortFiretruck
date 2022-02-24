package Cabin;

import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import Enums.LeftRightSide;
import User.User;

public class Cabin {
    Seat[][] seats = new Seat[2][2];
    Joystick LJ;
    Joystick RJ;
    public final Door LD;
    public final Door RD;

    void sitIn(User user, LeftRightSide side){

    }

    public Cabin(){
        seats[0][0] = new Seat(LeftRightPosition.LEFT, FrontBackPosition.FRONT);
        seats[0][1] = new Seat(LeftRightPosition.RIGHT, FrontBackPosition.FRONT);
        seats[1][0] = new Seat(LeftRightPosition.LEFT, FrontBackPosition.BACK);
        seats[1][1] = new Seat(LeftRightPosition.RIGHT, FrontBackPosition.BACK);
        LJ = new Joystick(LeftRightPosition.LEFT);
        RJ = new Joystick(LeftRightPosition.RIGHT);
        LD = new Door(LeftRightPosition.LEFT);
        RD = new Door(LeftRightPosition.RIGHT);
    }
}
