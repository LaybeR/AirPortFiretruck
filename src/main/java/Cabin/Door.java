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
    if (status == DoorStatus.IN) status = DoorStatus.OUT;
    else status = DoorStatus.IN;
    }
    Door(LeftRightPosition sde){
        this.side = sde;
        DBIN = new DoorButton(DoorSide.IN,this);
        DBOUT = new DoorButton(DoorSide.OUT,this);
    }

}
