package User;

import Cabin.Seat;
import Enums.FrontBackPosition;
import Enums.LeftRightPosition;

public class Person implements IUser {

    public IUser sitDown(Seat seat){
        if (seat.getFrontOrBack() == FrontBackPosition.BACK)
            return new Passenger(seat);
        else if (seat.getFrontOrBack() == FrontBackPosition.FRONT) {
            if (seat.getSide() == LeftRightPosition.LEFT) {
                return new Driver(seat);
            } else if (seat.getSide() == LeftRightPosition.RIGHT) {
                return new Operator(seat);
            }
        }
        return null;
    }

    public IUser leaveSeat(){
        return this;
    }
}
