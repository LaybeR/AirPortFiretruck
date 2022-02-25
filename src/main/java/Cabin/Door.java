package Cabin;

import Enums.DoorSide;
import Enums.DoorStatus;
import Enums.LeftRightPosition;

public class Door {
    private final LeftRightPosition side;
    DoorStatus status;
    public final DoorButton DBIN;
    public final DoorButton DBOUT;

    void changeDoorStatus(){
    if (status == DoorStatus.CLOSED) status = DoorStatus.OPEN;
    else status = DoorStatus.CLOSED;
    }
    Door(LeftRightPosition sde){
        this.side = sde;
        status = DoorStatus.CLOSED;
        DBIN = new DoorButton(DoorSide.IN,this);
        DBOUT = new DoorButton(DoorSide.OUT,this);
    }

    public DoorStatus getStatus() {
        return status;
    }
}
