package AirportFireTruck;

import Cabin.Cabin;
import Controller.Knob;
import Controller.SteeringWheel;
import Controller.Switch;
import Enums.KnobDirectionType;
import Enums.LeftRightPosition;
import Enums.SteeringDirection;
import User.User;
import User.Driver;
import User.Operator;
import User.Person;
import User.Passenger;

public class AirportFireTruck {
    private final ICentralUnit centralUnit;
    private final Cabin cabin;

    private AirportFireTruck(int count) {
        this.cabin = new Cabin();
        this.centralUnit = new CentralUnit();
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

    public void pressDoorButtonLeft(User user) {
        if (user instanceof Person) {
            cabin.LD.DBOUT.press();
        } else if (user instanceof Passenger) {
            Passenger temp = (Passenger) user;
            if (temp.seatedIn().getSide() == LeftRightPosition.LEFT) {
                cabin.LD.DBIN.press();
            }
        }
    }

    public void pressDoorButtonRight(User user) {
        if (user instanceof Person) {
            cabin.RD.DBOUT.press();
        } else if (user instanceof Passenger) {
            Passenger temp = (Passenger) user;
            if (temp.seatedIn().getSide() == LeftRightPosition.RIGHT) {
                cabin.RD.DBIN.press();
            }
        }
    }

    public void pressSwitch(Switch selectedSwitch, User user) {
        if (user instanceof Operator) {
            selectedSwitch.press();
        }
    }

    public void turnKnob(Knob selectedKnob, User user, KnobDirectionType direction) {
        if (user instanceof Operator) {
            switch (direction) {
                case CLOCKWISE -> selectedKnob.turnClockwise();
                case COUNTER_CLOCKWISE -> selectedKnob.turnCounterClockwise();
            }
        }
    }

    public void pressGas(User user) {
        if (user instanceof Driver) {
            centralUnit.getGasPedal().press();
        }
    }

    public void pressBrake(User user) {
        if (user instanceof Driver) {
            centralUnit.getBrakePedal().press();
        }
    }

    public void turnSteeringWheel(User user, SteeringDirection steeringDirection) {
        if (user instanceof Driver) {
            SteeringWheel steeringWheel = centralUnit.getSteeringWheel();
            switch (steeringDirection) {
                case LEFT -> steeringWheel.turnLeft();
                case RIGHT -> steeringWheel.turnRight();
                case CENTER -> steeringWheel.returnToCenter();
            }
        }
    }
}
