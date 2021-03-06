package User;

import Cabin.Seat;
import Enums.FrontBackPosition;

public class Passenger implements IUser {
    Seat seat;

    public Passenger(Seat seat) {
        this.seat = seat;
    }
    public Seat seatedIn(){
        return seat;
    }

    @Override
    public IUser sitDown(Seat seat) {
        return this;
    }

    @Override
    public IUser leaveSeat() {
        seat.freeSeat();
        return new Person();
    }
}
