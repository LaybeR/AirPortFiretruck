package Cabin;

import Enums.LeftRightPosition;

public class Joystick {
    LeftRightPosition side;
    JoystickButton LB;
    JoystickButton RB;
    Feeler feeler;

    Joystick(LeftRightPosition sde){
        this.side = sde;
        create();
    }
    void create(){
        LB = new JoystickButton(LeftRightPosition.LEFT);
        RB = new JoystickButton(LeftRightPosition.RIGHT);
        feeler = new Feeler();
    }
}

