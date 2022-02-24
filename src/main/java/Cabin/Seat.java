package Cabin;

import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import User.IUser;

public class Seat {
    LeftRightPosition side;
    FrontBackPosition position;
    IUser person;

    Seat(LeftRightPosition sde, FrontBackPosition pos){
        this.side = sde;
        this.position = pos;
        person = null;
    }

    IUser sitIn(IUser user){
        user = user.sitDown(this);
        person = user;
        return person;
    }

    public void freeSeat() {
        person = null;
    }

    boolean isFilled() {
        return person != null;
    }

    public LeftRightPosition getSide() {
        return side;
    }

    public FrontBackPosition getFrontOrBack() {return position;}
}
