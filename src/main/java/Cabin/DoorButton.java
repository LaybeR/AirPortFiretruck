package Cabin;

import Enums.DoorSide;

public class DoorButton {
    private final DoorSide doorSide;
    private final Door door;

    void press(){
        door.changeDoorStatus();
    }
    DoorButton(DoorSide DS, Door door){
        this.door = door;
        this.doorSide = DS;
    }
}
