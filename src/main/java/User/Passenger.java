package User;

import Cabin.Seat;

public abstract class Passenger extends User{
    Seat seat;
    public Seat seatedIn(){
        return seat;
    }
}
