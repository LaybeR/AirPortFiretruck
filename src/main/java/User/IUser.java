package User;

import Cabin.Seat;
import Enums.FrontBackPosition;

public interface IUser {
    public IUser sitDown(Seat seat);
    public IUser leaveSeat();
}
