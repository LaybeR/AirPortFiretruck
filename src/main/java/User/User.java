package User;

import Cabin.Seat;

public abstract class User {
    public User sitDown(Seat seat){
        return this;
    }
    public User leaveSeat(){
        return this;
    }
}
