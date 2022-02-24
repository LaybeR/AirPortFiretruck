package Cabin;

import AirportFireTruck.ICentralUnit;
import Enums.DoorStatus;
import Enums.FrontBackPosition;
import Enums.LeftRightPosition;
import Enums.LeftRightSide;
import User.IUser;
import User.Passenger;
import User.Person;

public class Cabin {
    Seat[][] seats = new Seat[2][2];
    public final Joystick LJ;
    public final Joystick RJ;
    public final Door LD;
    public final Door RD;
    private final ICentralUnit centralUnit;

    public IUser leaveSeat(IUser user) {
        if (user instanceof Person) return user;
        if (LD.status == DoorStatus.OPEN && ((Passenger) user).seatedIn().getSide() == LeftRightPosition.LEFT) return user.leaveSeat();
        if (RD.status == DoorStatus.OPEN && ((Passenger) user).seatedIn().getSide() == LeftRightPosition.RIGHT) return user.leaveSeat();
        return user;
    }

    public IUser sitIn(IUser user, LeftRightSide side, FrontBackPosition position){
        if (user instanceof Person) {
            if (side == LeftRightSide.LEFT && LD.status == DoorStatus.CLOSED) return user;
            if (side == LeftRightSide.RIGHT && RD.status == DoorStatus.CLOSED) return user;
            int x = position == FrontBackPosition.FRONT ? 0 : 1;
            int y = side == LeftRightSide.LEFT ? 0 : 1;
            if (!seats[x][y].isFilled()) {
                return seats[x][y].sitIn(user);
            }
        }
        return user;
    }

    public Cabin(ICentralUnit centralUnit){
        this.centralUnit = centralUnit;
        seats[0][0] = new Seat(LeftRightPosition.LEFT, FrontBackPosition.FRONT);
        seats[0][1] = new Seat(LeftRightPosition.RIGHT, FrontBackPosition.FRONT);
        seats[1][0] = new Seat(LeftRightPosition.LEFT, FrontBackPosition.BACK);
        seats[1][1] = new Seat(LeftRightPosition.RIGHT, FrontBackPosition.BACK);
        LJ = new Joystick(LeftRightPosition.LEFT, this);
        RJ = new Joystick(LeftRightPosition.RIGHT, this);
        LD = new Door(LeftRightPosition.LEFT);
        RD = new Door(LeftRightPosition.RIGHT);
    }

    public void holdFeeler(LeftRightPosition side){
    switch (side){
        case LEFT -> centralUnit.getFrontCannon().setFiring(true);
        case RIGHT -> centralUnit.getRoofCannon().setFiring(true);
    }

    }

    public void releaseFeeler(LeftRightPosition side) {
        switch (side){
            case LEFT -> centralUnit.getFrontCannon().setFiring(false);
            case RIGHT -> centralUnit.getRoofCannon().setFiring(false);
        }
    }

    public void pressJoystickButton(LeftRightPosition joystickSide, LeftRightPosition buttonSide) {
        switch (joystickSide){
            case LEFT -> {
                switch (buttonSide){
                    case LEFT -> {
                        if(centralUnit.getFrontCannon().isActivated()) centralUnit.getFrontCannon().deactivate();
                        if(!centralUnit.getFrontCannon().isActivated()) centralUnit.getFrontCannon().activate();
                    }
                    case RIGHT -> {
                        if(centralUnit.getFrontCannon().isActivated()) centralUnit.getFrontCannon().changeRatio();
                    }
                }
            }
            case RIGHT -> {
                switch (buttonSide){
                    case LEFT -> {
                        if(centralUnit.getRoofCannon().isActivated()) centralUnit.getRoofCannon().deactivate();
                        if(!centralUnit.getRoofCannon().isActivated()) centralUnit.getRoofCannon().activate();
                    }
                    case RIGHT -> {
                        if(centralUnit.getRoofCannon().isActivated()) centralUnit.getRoofCannon().changeRatio();
                    }
                }
            }
        }
    }
}
