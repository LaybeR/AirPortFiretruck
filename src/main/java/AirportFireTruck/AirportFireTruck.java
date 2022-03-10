package AirportFireTruck;

import Cabin.Cabin;
import Controller.Knob;
import Controller.SteeringWheel;
import Controller.Switch;
import Enums.*;
import User.IUser;
import User.Driver;
import User.Operator;
import User.Person;
import User.Passenger;
import Cabin.Joystick;
import Cabin.Seat;

public class AirportFireTruck {
    private final ICentralUnit centralUnit;
    private final ControlPanel controlPanel;
    private final Cabin cabin;

    public AirportFireTruck(int count) {
        this.controlPanel = new ControlPanel();
        this.centralUnit = new CentralUnit(controlPanel, count);
        controlPanel.setCentralUnit(centralUnit);
        this.cabin = new Cabin(centralUnit);
    }

    public static class Builder {
        int headlights = 6;

        public Builder headlights(int count) {
            headlights = count;
            return this;
        }

        public AirportFireTruck build() {
            return new AirportFireTruck(headlights);
        }
    }

    public void pressDoorButtonLeft(IUser user) {
        if (user instanceof Person) {
            cabin.LD.DBOUT.press();
        } else if (user instanceof Passenger temp) {
            if (temp.seatedIn().getSide() == LeftRightPosition.LEFT) {
                cabin.LD.DBIN.press();
            }
        }
    }

    public void pressDoorButtonRight(IUser user) {
        if (user instanceof Person) {
            cabin.RD.DBOUT.press();
        } else if (user instanceof Passenger temp) {
            if (temp.seatedIn().getSide() == LeftRightPosition.RIGHT) {
                cabin.RD.DBIN.press();
            }
        }
    }

    public IUser sitIn(IUser user, LeftRightSide side, FrontBackPosition position) {
        return cabin.sitIn(user,side,position);
    }

    public IUser leaveSeat(IUser user) {
        return cabin.leaveSeat(user);
    }

    public void iterate() {
        centralUnit.iterate();
        centralUnit.getChargingStation().charge();
    }

    public void turnKnob(Knob selectedKnob, IUser user, KnobDirectionType direction) {
        if (user instanceof Operator) {
            switch (direction) {
                case CLOCKWISE -> selectedKnob.turnClockwise();
                case COUNTER_CLOCKWISE -> selectedKnob.turnCounterClockwise();
            }
        }
    }

    public Joystick getJoystick(LeftRightPosition side) {
        Joystick result = null;
        switch (side) {
            case LEFT -> result = cabin.LJ;
            case RIGHT -> result = cabin.RJ;
        }
        return result;
    }

    public Switch getSwitch(SwitchType type) {
        return controlPanel.getSwitch(type);
    }

    public Knob getKnob(KnobType type) {
        return controlPanel.getKnob(type);
    }

    public void turnWheel(IUser user, SteeringDirection steeringDirection) {
        if (user instanceof Driver) {
            SteeringWheel steeringWheel = centralUnit.getSteeringWheel();
            switch (steeringDirection) {
                case LEFT -> steeringWheel.turnLeft();
                case RIGHT -> steeringWheel.turnRight();
                case CENTER -> steeringWheel.returnToCenter();
            }
        }
    }

    public void pressGas(IUser user) {
        if (user instanceof Driver) {
            centralUnit.getGasPedal().press();
        }
    }

    public void pressBrake(IUser user) {
        if (user instanceof Driver) {
            centralUnit.getBrakePedal().press();
        }
    }

    public void postDisplay() {
        centralUnit.postDisplay();
    }

    public Seat[][] getSeats(){
        return cabin.getSeats();
    }

    public DoorStatus getLeftDoorstatus(){
        return cabin.getLeftDoorStatus();
    }

    public DoorStatus getRightDoorstatus(){
        return cabin.getRightDoorStatus();
    }

    public ICentralUnit getCentralUnit() {
        return centralUnit;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

}
