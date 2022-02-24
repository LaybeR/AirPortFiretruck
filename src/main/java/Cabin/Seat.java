package Cabin;

import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import User.IUser;

public class Seat {
    LeftRightPosition side;
    FrontBackPosition position;

    IUser sitIn(IUser user){
    return user;
    }
    Seat(LeftRightPosition sde, FrontBackPosition pos){
        this.side = sde;
        this.position = pos;
    }

    public LeftRightPosition getSide() {
        return side;
    }
    public FrontBackPosition getFrontOrBack() {return position;}
}
