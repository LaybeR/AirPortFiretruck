package Cabin;

import Enums.DoorSide;
import Enums.DoorStatus;
import Enums.LeftRightPosition;

public class Door {
    LeftRightPosition side;
    DoorStatus status;
    DoorButton DBIN;
    DoorButton DBOUT;

    void changeDoorStatus(){
    if (status == DoorStatus.IN) status = DoorStatus.OUT;
    else status = DoorStatus.IN;
    }
    Door(LeftRightPosition sde){
        this.side = sde;
        create();
    }
    void create(){
        DBIN = new DoorButton(DoorSide.IN);
        DBOUT = new DoorButton(DoorSide.OUT);
    }
}
