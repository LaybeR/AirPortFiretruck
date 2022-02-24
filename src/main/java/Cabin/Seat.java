package Cabin;

import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import User.User;

public class Seat {
    LeftRightPosition side;
    FrontBackPosition position;

    User sitIn(User user){
    return user;
    }
    Seat(LeftRightPosition sde, FrontBackPosition pos){
        this.side = sde;
        this.position = pos;
    }

    public LeftRightPosition getSide() {
        return side;
    }
}
