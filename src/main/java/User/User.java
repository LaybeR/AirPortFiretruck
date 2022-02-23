package User;

import Cabin.Seat;

public abstract class User {
    User user;
    User sitDown(Seat seat){
        return user;
    }
    User leaveSeat(){
        return user;
    }
}
