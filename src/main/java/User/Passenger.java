package User;

import Cabin.Seat;

public abstract class Passenger extends User{
    Seat seat;
    Seat seatedIn(){
        return seat;
    }
}
