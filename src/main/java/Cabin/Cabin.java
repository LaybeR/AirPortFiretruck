package Cabin;

import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import Enums.LeftRightSide;
import User.User;

public class Cabin {
    Seat[][] seats = new Seat[2][2];
    Joystick LJ;
    Joystick RJ;
    Door LD;
    Door RD;
    void pressDoorButton(DoorButton button){

    }
    void sitIn(User user, LeftRightSide side){

    }
    Cabin(){
        create();
    }
    void create(){
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
